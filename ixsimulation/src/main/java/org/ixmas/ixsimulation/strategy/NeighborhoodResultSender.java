package org.ixmas.ixsimulation.strategy;

import org.ixmas.ixsimulation.space.grid.Grid1D;

import java.util.List;

class NeighborhoodResultSender implements ResultSender {

    private final int m_turnNumber;
    private final Simulator1D m_beforeSimulator1D;
    private final Simulator1D m_afterSimulator1D;
    private int m_turn = 0;

    NeighborhoodResultSender(int agentIdx, int turnNumber, List<Simulator1D> simulator1Ds) {
        m_turnNumber = turnNumber;
        m_beforeSimulator1D = simulator1Ds.get((agentIdx + simulator1Ds.size() - 1) % simulator1Ds.size());
        m_afterSimulator1D = simulator1Ds.get((agentIdx + 1) % simulator1Ds.size());
    }

    @Override
    public boolean isTurnToSend() {
        if (m_turnNumber == 0) {
            return false;
        }
        m_turn++;
        return m_turn % m_turnNumber == 0;
    }

    @Override
    public void sendResult(Grid1D grid) {
        m_beforeSimulator1D.receiveResultFromAfter(grid);
        m_afterSimulator1D.receiveResultFromBefore(grid);
    }
}
