package org.ixmas.space.torus;

import org.ixmas.space.grid.Grid1D;

public class Torus1D {

    private final int m_circumference;

    private double[] m_values;

    public Torus1D(int circumference) {
        m_circumference = circumference;
        m_values = new double[circumference];
    }

    public double get(int x) {
        return m_values[(x + m_circumference) % m_circumference];
    }

    public void put(int x, double value) {
        m_values[(x + m_circumference) % m_circumference] = value;
    }

    public int getCircumference() {
        return m_circumference;
    }


    public Grid1D createGrid(int xMin, int xMax, int overlap) {
        Grid1D grid = new Grid1D(xMax - xMin + 2 * overlap);
        int gridIdx = 0;
        for (int idx = xMin - overlap; idx < xMax + overlap; idx++) {
            grid.put(gridIdx, get(idx));
            gridIdx++;
        }
        return grid;
    }
}
