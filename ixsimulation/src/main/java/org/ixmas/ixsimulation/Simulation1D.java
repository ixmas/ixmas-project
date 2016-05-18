package org.ixmas.ixsimulation;

import org.ixmas.ixsimulation.strategy.Strategy1D;

class Simulation1D {

    private final Strategy1D m_strategy;

    Simulation1D(Strategy1D strategy1D) {
        m_strategy = strategy1D;
    }

    void simulate(Context context) throws InterruptedException {
        m_strategy.buildAgents(context);
        m_strategy.start();
    }

}
