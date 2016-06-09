package org.ixmas.ixsimulation.computing;

public interface Computing1D {

    int getNeighborhood();
    double compute(double before, double previous, double after);

}
