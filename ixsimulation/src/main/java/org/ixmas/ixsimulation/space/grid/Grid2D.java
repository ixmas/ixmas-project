package org.ixmas.ixsimulation.space.grid;

public class Grid2D {

    private final int m_xSize;
    private final int m_ySize;
    private double[][] m_values;

    public Grid2D(int xSize, int ySize) {
        m_xSize = xSize;
        m_ySize = ySize;
        m_values = new double[xSize][];
        for (int x = 0; x < xSize; x++) {
            m_values[x] = new double[ySize];
        }
    }

    public double get(int x, int y) {
        return m_values[x][y];
    }

    public void put(int x, int y, double value) {
        m_values[x][y] = value;
    }

    public int getXSize() {
        return m_xSize;
    }

    public int getYSize() {
        return m_ySize;
    }

}
