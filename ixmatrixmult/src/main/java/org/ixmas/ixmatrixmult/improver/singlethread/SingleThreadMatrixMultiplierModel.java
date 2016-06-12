package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierMetrics;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierModel;
import org.ixmas.ixmodel.metrics.Metrics;

public class SingleThreadMatrixMultiplierModel implements MatrixMultiplierModel {

    @Override
    public Metrics evaluate(MatrixModel matrixModel1, MatrixModel matrixModel2) {
        Metrics metrics = new MatrixMultiplierMetrics();
        metrics.getMetricsValues().putValue(MatrixMultiplierMetrics.operationNumber, matrixModel1.getLineNumber() * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2).putValue(MatrixMultiplierMetrics.valueCopy, 0).putValue(MatrixMultiplierMetrics.memorySize, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        return metrics;
    }

}
