package org.ixmas.ixsimulation;

public interface Context {
    Context create();

    boolean hasFinished();
}
