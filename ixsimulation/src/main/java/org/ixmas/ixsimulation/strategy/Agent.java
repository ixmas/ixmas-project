package org.ixmas.ixsimulation.strategy;

import org.ixmas.computing.Computing1D;
import org.ixmas.space.grid.Grid1D;

class Agent implements Runnable {
    private final Computing1D m_computing;
    private final int m_overlap;
    private final int m_xMin;
    private final int m_xMax;
    private Grid1D m_grid;
    private Grid1D m_gridNext;

    Agent(Grid1D grid, Computing1D computing, int xMin, int xMax, int overlap) {
        m_grid = grid;
        m_xMin = xMin;
        m_xMax = xMax;
        m_gridNext = new Grid1D(grid.getSize());
        m_computing = computing;
        m_overlap = overlap;
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
        for (int x = m_overlap; x < m_grid.getSize() - m_overlap; x++) {
            m_gridNext.put(x, m_computing.compute(m_grid.get(x - 1), m_grid.get(x), m_grid.get(x + 1)));
        }
        Grid1D m_gridTmp = m_grid;
        m_grid = m_gridNext;
        m_gridNext = m_gridTmp;
    }
}
