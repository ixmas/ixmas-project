package org.ixmas.ixsimulation;

public interface Finisher {
    Finisher create();

    boolean hasFinished();
}
