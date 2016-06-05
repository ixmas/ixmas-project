package org.ixmas.ixsimulation.strategy;

import org.ixmas.space.grid.Grid1D;

import java.util.List;

class NeighborhoodResultSender implements ResultSender {

    private final int m_turnNumber;
    private final Agent m_beforeAgent;
    private final Agent m_afterAgent;
    private int m_turn = 0;

    NeighborhoodResultSender(int agentIdx, int turnNumber, List<Agent> agents) {
        m_turnNumber = turnNumber;
        m_beforeAgent = agents.get((agentIdx + agents.size() - 1) % agents.size());
        m_afterAgent = agents.get((agentIdx + 1) % agents.size());
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
        m_beforeAgent.receiveResultFromAfter(grid);
        m_afterAgent.receiveResultFromBefore(grid);
    }
}
