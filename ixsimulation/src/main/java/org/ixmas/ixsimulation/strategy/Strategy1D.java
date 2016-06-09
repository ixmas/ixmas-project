package org.ixmas.ixsimulation.strategy;

import org.ixmas.ixsimulation.Finisher;
import org.ixmas.ixsimulation.computing.Computing1D;
import org.ixmas.ixsimulation.space.grid.Grid1D;
import org.ixmas.ixsimulation.space.torus.Torus1D;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Strategy1D {

    private final int m_agentNumber;
    private final int m_overlap;
    private Torus1D m_torus1D;
    private Computing1D m_computing;
    private List<Simulator1D> m_simulator1Ds;

    public Strategy1D(Torus1D torus1D, Computing1D computing, int agentNumber, int overlap) {
        m_torus1D = torus1D;
        m_computing = computing;
        m_agentNumber = agentNumber;
        m_overlap = overlap;
    }

    public void buildAgents(Finisher finisher, int turnNbResultSender) {
        m_simulator1Ds = new ArrayList<>(m_agentNumber);
        int circumference = m_torus1D.getCircumference();
        int gridSize = circumference / m_agentNumber;
        for (int agentIdx = 0; agentIdx < m_agentNumber; agentIdx++) {
            int xMin = agentIdx * gridSize;
            int xMax = min((agentIdx + 1) * gridSize, circumference);
            Grid1D grid = m_torus1D.createGrid(xMin, xMax, m_overlap);
            m_simulator1Ds.add(new Simulator1D("agent" + agentIdx, grid, m_computing, xMin, xMax, m_overlap, finisher.create()));
        }
        for (int agentIdx = 0; agentIdx < m_agentNumber; agentIdx++) {
            m_simulator1Ds.get(agentIdx).setResultSender(new NeighborhoodResultSender(agentIdx, turnNbResultSender, m_simulator1Ds));
        }
    }

    public void start() throws InterruptedException {
        List<Thread> threads = new ArrayList<>(m_simulator1Ds.size());
        for (Simulator1D simulator1D : m_simulator1Ds) {
            Thread thread = new Thread(simulator1D);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        mergeResults();
    }

    private void mergeResults() {
        for (Simulator1D simulator1D : m_simulator1Ds) {
            for (int x = simulator1D.getXMin(); x < simulator1D.getXMax(); x++) {
                int agentX = x - simulator1D.getXMin() + m_overlap;
                double value = simulator1D.getGrid().get(agentX);
                m_torus1D.put(x, value);
            }
        }
    }

}
