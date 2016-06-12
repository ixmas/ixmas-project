package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierMetrics;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierModel;
import org.ixmas.ixmodel.metrics.Metrics;

public class MultiThreadMatrixMultiplierModel implements MatrixMultiplierModel {

    private final int m_auxiliaryNumber;

    public MultiThreadMatrixMultiplierModel(int auxiliaryNumber) {
        m_auxiliaryNumber = auxiliaryNumber;
    }

    @Override
    public Metrics evaluate(MatrixModel matrixModel1, MatrixModel matrixModel2) {
        Metrics metrics = new MatrixMultiplierMetrics();
        int lineNumberPerAuxiliary = matrixModel1.getLineNumber() / m_auxiliaryNumber;
        if (lineNumberPerAuxiliary < 1) {
            lineNumberPerAuxiliary = 1;
        }
        metrics.getMetricsValues().putValue(MatrixMultiplierMetrics.operationNumberPerAuxiliary, lineNumberPerAuxiliary * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2).putValue(MatrixMultiplierMetrics.valueCopy, matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).putValue(MatrixMultiplierMetrics.memorySize, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).
                putValue(MatrixMultiplierMetrics.memorySizePerAuxiliary, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                        + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                        + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        return metrics;
    }

}
