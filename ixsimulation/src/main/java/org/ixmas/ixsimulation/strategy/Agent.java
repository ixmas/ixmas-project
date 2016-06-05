package org.ixmas.ixsimulation.strategy;

import org.ixmas.computing.Computing1D;
import org.ixmas.ixsimulation.Finisher;
import org.ixmas.space.grid.Grid1D;

import java.util.concurrent.atomic.LongAdder;

class Agent implements Runnable {
    private final Computing1D m_computing;
    private final int m_overlap;
    private final Finisher m_finisher;
    private final int m_xMin;
    private final int m_xMax;
    private final String m_name;
    private ResultSender m_resultSender;
    private Grid1D m_grid;
    private Grid1D m_gridNext;
    private LongAdder m_received = new LongAdder();

    Agent(String name, Grid1D grid, Computing1D computing, int xMin, int xMax, int overlap, Finisher finisher) {
        m_name = name;
        m_grid = grid;
        m_xMin = xMin;
        m_xMax = xMax;
        m_gridNext = new Grid1D(grid.getSize());
        m_computing = computing;
        m_overlap = overlap;
        m_finisher = finisher;
    }

    Grid1D getGrid() {
        return m_grid;
    }

    int getXMin() {
        return m_xMin;
    }

    int getXMax() {
        return m_xMax;
    }

    @Override
    public void run() {
        while (!m_finisher.hasFinished()) {
            for (int x = m_computing.getNeighborhood(); x < m_grid.getSize() - m_computing.getNeighborhood(); x++) {
                m_gridNext.put(x, m_computing.compute(m_grid.get(x - 1), m_grid.get(x), m_grid.get(x + 1)));
            }
            Grid1D m_gridTmp = m_grid;
            m_grid = m_gridNext;
            m_gridNext = m_gridTmp;
            if (m_resultSender.isTurnToSend()) {
                m_resultSender.sendResult(m_grid);
                waitOthersResults();
                m_received.reset();
            }
        }
    }

    private void waitOthersResults() {
        while (m_received.longValue() != 2) {
        }
    }


    void setResultSender(ResultSender resultSender) {
        m_resultSender = resultSender;
    }

    void receiveResultFromAfter(Grid1D grid) {
        for (int x = 0; x < m_overlap; x++) {
            double value = grid.get(m_overlap + x);
            int thisX = m_grid.getSize() - m_overlap + x;
            m_grid.put(thisX, value);
        }
        m_received.increment();
    }

    void receiveResultFromBefore(Grid1D grid) {
        for (int x = 0; x < m_overlap; x++) {
            int otherX = grid.getSize() - 2 * m_overlap + x;
            double value = grid.get(otherX);
            m_grid.put(x, value);
        }
        m_received.increment();
    }
}
