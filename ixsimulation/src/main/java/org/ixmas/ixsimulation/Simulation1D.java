package org.ixmas.ixsimulation;

import org.ixmas.ixsimulation.strategy.Strategy1D;

class Simulation1D {

    private final Strategy1D m_strategy;

    Simulation1D(Strategy1D strategy1D) {
        m_strategy = strategy1D;
    }

    void simulate(Finisher finisher, int turnNbResultSender) throws InterruptedException {
        m_strategy.buildAgents(finisher, turnNbResultSender);
        m_strategy.start();
    }

}
