package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixMultiplierModel;

import static com.google.common.base.Preconditions.checkArgument;

public class MultiThreadMatrixMultiplierModel implements MatrixMultiplierModel {

    private final int m_auxiliaryNumber;

    public MultiThreadMatrixMultiplierModel(int auxiliaryNumber) {
        checkArgument(auxiliaryNumber > 0);
        m_auxiliaryNumber = auxiliaryNumber;
    }

    public int getAuxiliaryNumber() {
        return m_auxiliaryNumber;
    }

    @Override
    public String toString() {
        return "MultiThreadMatrixMultiplierModel{" +
                "m_auxiliaryNumber=" + m_auxiliaryNumber +
                '}';
    }
}
