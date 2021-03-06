package org.ixmas.ixsimulation;

import org.ixmas.ixsimulation.computing.Computing1D;
import org.ixmas.ixsimulation.space.torus.Torus1D;
import org.ixmas.ixsimulation.strategy.Strategy1D;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Simulation1DTest {

    private Computing1D m_computing1D = new Computing1D() {
        @Override
        public int getNeighborhood() {
            return 1;
        }

        @Override
        public double compute(double before, double previous, double after) {
            return (before / 2. + previous + after / 2.) / 2.;
        }
    };

    @Test
    public void shouldChangeNothingInUniformCase() throws InterruptedException {
        int agentNumber = 10;
        Torus1D torus1D = new Torus1D(100);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            torus1D.put(x, 12);
        }
        Strategy1D strategy1D = new Strategy1D(torus1D, m_computing1D, agentNumber, 1);
        Simulation1D simulation1D = new Simulation1D(strategy1D);
        simulation1D.simulate(new TurnNumberFinisher(1), 0);
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
        Strategy1D strategy1D = new Strategy1D(torus1D, m_computing1D, agentNumber, 1);
        Simulation1D simulation1D = new Simulation1D(strategy1D);
        simulation1D.simulate(new TurnNumberFinisher(1), 0);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            assertThat(torus1D.get(x)).as("x=" + x).isEqualTo(expectedValues[x]);
        }
    }

    @Test
    public void shouldBeExactIfNumberOfTurnEqualsOverlap() throws InterruptedException {
        int agentNumber = 10;
        Torus1D torus1D = new Torus1D(100);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            torus1D.put(x, 12);
        }
        Strategy1D strategy1D = new Strategy1D(torus1D, m_computing1D, agentNumber, 2);
        Simulation1D simulation1D = new Simulation1D(strategy1D);
        simulation1D.simulate(new TurnNumberFinisher(2), 0);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            assertThat(torus1D.get(x)).as("x=" + x).isEqualTo(12.);
        }
    }

    @Test
    public void shouldBeExactIfNumberOfTurnExchangeEqualsOverlap() throws InterruptedException {
        int agentNumber = 10;
        Torus1D torus1D = new Torus1D(100);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            torus1D.put(x, 12);
        }
        Strategy1D strategy1D = new Strategy1D(torus1D, m_computing1D, agentNumber, 2);
        Simulation1D simulation1D = new Simulation1D(strategy1D);
        simulation1D.simulate(new TurnNumberFinisher(2), 2);
        for (int x = 0; x < torus1D.getCircumference(); x++) {
            assertThat(torus1D.get(x)).as("x=" + x).isEqualTo(12.);
        }
    }

}
