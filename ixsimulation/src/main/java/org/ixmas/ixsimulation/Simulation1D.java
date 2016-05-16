package org.ixmas.ixsimulation;

import org.ixmas.computing.Computing1D;
import org.ixmas.ixsimulation.strategy.Strategy1D;
import org.ixmas.space.torus.Torus1D;

class Simulation1D {

    private final Strategy1D m_strategy;
    private Torus1D m_torus1D;
    private Computing1D m_computing;

    Simulation1D(Torus1D torus1D, Computing1D computing, Strategy1D strategy1D) {
        m_torus1D = torus1D;
        m_computing = computing;
        m_strategy = strategy1D;
    }

    void simulate() throws InterruptedException {
        m_strategy.buildAgents();
        m_strategy.start();
    }

}
