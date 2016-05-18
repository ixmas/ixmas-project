package org.ixmas.ixsimulation.strategy;

import org.ixmas.computing.Computing1D;
import org.ixmas.ixsimulation.Context;
import org.ixmas.space.grid.Grid1D;
import org.ixmas.space.torus.Torus1D;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Strategy1D {

    private final int m_agentNumber;
    private final int m_overlap;
    private Torus1D m_torus1D;
    private Computing1D m_computing;
    private List<Agent> m_agents;

    public Strategy1D(Torus1D torus1D, Computing1D computing, int agentNumber, int overlap) {
        m_torus1D = torus1D;
        m_computing = computing;
        m_agentNumber = agentNumber;
        m_overlap = overlap;
    }

    public void buildAgents(Context context) {
        m_agents = new ArrayList<>(m_agentNumber);
        int circumference = m_torus1D.getCircumference();
        int gridSize = circumference / m_agentNumber;
        for (int agentIdx = 0; agentIdx < m_agentNumber; agentIdx++) {
            int xMin = agentIdx * gridSize;
            int xMax = min((agentIdx + 1) * gridSize, circumference);
            Grid1D grid = m_torus1D.createGrid(xMin, xMax, m_overlap);
            m_agents.add(new Agent(grid, m_computing, xMin, xMax, m_overlap, context.create()));
        }
    }

    public void start() throws InterruptedException {
        List<Thread> threads = new ArrayList<>(m_agents.size());
        for (Agent agent : m_agents) {
            Thread thread = new Thread(agent);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        mergeResults();
    }

    private void mergeResults() {
        for (Agent agent : m_agents) {
            for (int x = agent.getXMin(); x < agent.getXMax(); x++) {
                int agentX = x - agent.getXMin() + m_overlap;
                double value = agent.getGrid().get(agentX);
                m_torus1D.put(x, value);
            }
        }
    }

}
