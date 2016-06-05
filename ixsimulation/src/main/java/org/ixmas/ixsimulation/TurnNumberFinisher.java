package org.ixmas.ixsimulation;

class TurnNumberFinisher implements Finisher {

    private final int m_turnNumber;
    private int m_turn = 0;

    TurnNumberFinisher(int turnNumber) {
        m_turnNumber = turnNumber;
    }

    @Override
    public Finisher create() {
        return new TurnNumberFinisher(m_turnNumber);
    }

    @Override
    public boolean hasFinished() {
        m_turn++;
        return m_turn > m_turnNumber;
    }
}
