package org.ixmas.ixsimulation;

import org.ixmas.computing.Computing1D;
import org.ixmas.ixsimulation.strategy.Strategy1D;
import org.ixmas.space.torus.Torus1D;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Simulation1DTest {

    @Test
    public void shouldChangeNothingInUniformCase() throws InterruptedException {
        int agentNumber = 10;
        Torus1D torus1D = new Torus1D(100);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            torus1D.put(x, 12);
        }
        Computing1D computing1D = (before, previous, after) -> (before / 2. + previous + after / 2.) / 2.;
        Strategy1D strategy1D = new Strategy1D(torus1D, computing1D, agentNumber, 1);
        Simulation1D simulation1D = new Simulation1D(torus1D, computing1D, strategy1D);
        simulation1D.simulate();
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            assertThat(torus1D.get(x)).isEqualTo(12.);
        }
    }

    @Test
    public void shouldComputeAverage() throws InterruptedException {
        int agentNumber = 10;
        Torus1D torus1D = new Torus1D(100);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            torus1D.put(x, x);
        }
        double[] expectedValues = new double[torus1D.getCircumference()];
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            double expectedValue = (torus1D.get((x - 1 + torus1D.getCircumference()) % torus1D.getCircumference()) / 2. +
                    torus1D.get(x) +
                    torus1D.get((x + 1) % torus1D.getCircumference()) / 2.) / 2.;
            expectedValues[x] = expectedValue;
        }
        Computing1D computing1D = (before, previous, after) -> (before / 2. + previous + after / 2.) / 2.;
        Strategy1D strategy1D = new Strategy1D(torus1D, computing1D, agentNumber, 1);
        Simulation1D simulation1D = new Simulation1D(torus1D, computing1D, strategy1D);
        simulation1D.simulate();
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            assertThat(torus1D.get(x)).as("x=" + x).isEqualTo(expectedValues[x]);
        }
    }

}
