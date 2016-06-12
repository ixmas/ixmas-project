package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierModel;
import org.ixmas.ixmatrixmult.improver.Metrics;

public class SingleThreadMatrixMultiplierModel implements MatrixMultiplierModel {

    @Override
    public Metrics evaluate(MatrixModel matrixModel1, MatrixModel matrixModel2) {
        Metrics metrics = new Metrics();
        metrics.setOperationNumber(matrixModel1.getLineNumber() * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2);
        metrics.setValueCopy(0);
        metrics.setMemorySize(matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        return metrics;
    }

}
