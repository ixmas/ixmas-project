package org.ixmas.ixsimulation.strategy;

import org.ixmas.ixsimulation.space.grid.Grid1D;

interface ResultSender {

    boolean isTurnToSend();

    void sendResult(Grid1D grid);
}
