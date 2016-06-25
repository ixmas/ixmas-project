package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.HardwareModel;

public class MatrixHardwareModel implements HardwareModel {

    private int m_coreNumber;

    public MatrixHardwareModel(int coreNumber) {
        m_coreNumber = coreNumber;
    }

    public int getCoreNumber() {
        return m_coreNumber;
    }
}
