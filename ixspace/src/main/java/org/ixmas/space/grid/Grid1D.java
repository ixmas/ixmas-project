package org.ixmas.space.grid;

public class Grid1D {

    private final double[] m_values;
    private final int m_size;

    public Grid1D(int size) {
        m_size = size;
        m_values = new double[size];
    }

    public double get(int x) {
        return m_values[x];
    }

    public void put(int x, double value) {
        m_values[x] = value;
    }

    public int getSize() {
        return m_size;
    }

}
