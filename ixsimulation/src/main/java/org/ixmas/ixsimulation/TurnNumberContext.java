package org.ixmas.ixsimulation;

class TurnNumberContext implements Context {

    private final int m_turnNumber;
    private int m_turn = 0;

    TurnNumberContext(int turnNumber) {
        m_turnNumber = turnNumber;
    }

    @Override
    public Context create() {
        return new TurnNumberContext(m_turnNumber);
    }

    @Override
    public boolean hasFinished() {
        m_turn++;
        return m_turn > m_turnNumber;
    }
}
