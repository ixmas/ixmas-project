package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixSoftwareModel;

import static com.google.common.base.Preconditions.checkArgument;

public class MultiThreadMatrixSoftwareModel implements MatrixSoftwareModel {

    private final int m_threadNumber;

    public MultiThreadMatrixSoftwareModel(int threadNumber) {
        checkArgument(threadNumber > 0);
        m_threadNumber = threadNumber;
    }

    public int getThreadNumber() {
        return m_threadNumber;
    }

    @Override
    public String toString() {
        return "MultiThreadMatrixSoftwareModel{" +
                "m_threadNumber=" + m_threadNumber +
                '}';
    }
}
