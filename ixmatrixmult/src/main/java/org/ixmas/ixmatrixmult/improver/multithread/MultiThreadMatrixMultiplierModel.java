package org.ixmas.ixmatrixmult.improver.multithread;

public class MultiThreadMatrixMultiplierModel {

    private final int m_auxiliaryNumber;

    public MultiThreadMatrixMultiplierModel(int auxiliaryNumber) {
        m_auxiliaryNumber = auxiliaryNumber;
    }

    public int getAuxiliaryNumber() {
        return m_auxiliaryNumber;
    }
}
