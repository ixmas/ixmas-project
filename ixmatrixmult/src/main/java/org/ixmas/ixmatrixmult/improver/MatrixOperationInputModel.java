package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.InputModel;

public class MatrixOperationInputModel implements InputModel {

    private MatrixModel m_matrixModel1;
    private MatrixModel m_matrixModel2;

    public MatrixOperationInputModel(MatrixModel matrixModel1, MatrixModel matrixModel2) {
        m_matrixModel1 = matrixModel1;
        m_matrixModel2 = matrixModel2;
    }

    public MatrixModel getMatrixModel1() {
        return m_matrixModel1;
    }

    public MatrixModel getMatrixModel2() {
        return m_matrixModel2;
    }
}
