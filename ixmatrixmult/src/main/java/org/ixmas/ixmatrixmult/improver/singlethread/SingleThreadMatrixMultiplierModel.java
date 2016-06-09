package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierModel;
import org.ixmas.ixmatrixmult.improver.Metrics;

public class SingleThreadMatrixMultiplierModel implements MatrixMultiplierModel {

    @Override
    public Metrics evaluate(MatrixModel matrixModel1, MatrixModel matrixModel2) {
        Metrics metrics = new Metrics();
        metrics.increaseOperationNumber(matrixModel1.getLineNumber() * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2);
        metrics.increaseValueCopy(0);
        metrics.increaseMemorySize(0);
        return metrics;
    }

}
