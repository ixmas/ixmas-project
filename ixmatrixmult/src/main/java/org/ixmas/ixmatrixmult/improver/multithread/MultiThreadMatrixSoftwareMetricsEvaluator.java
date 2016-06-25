package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixSoftwareMetricsEvaluator;
import org.ixmas.ixmodel.improver.SoftwareModel;
import org.ixmas.ixmodel.metrics.SoftwareMetrics;

import static org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixSoftwareMetrics.*;

public class MultiThreadMatrixSoftwareMetricsEvaluator implements MatrixSoftwareMetricsEvaluator {

    @Override
    public SoftwareMetrics evaluate(SoftwareModel softwareModel, MatrixModel matrixModel1, MatrixModel matrixModel2) {
        SoftwareMetrics metrics = new MultiThreadMatrixSoftwareMetrics();
        int lineNumberPerThread = matrixModel1.getLineNumber() / ((MultiThreadMatrixSoftwareModel) softwareModel).getThreadNumber();
        if (lineNumberPerThread < 1) {
            lineNumberPerThread = 1;
        }
        metrics.putValue(THREAD_NUMBER, ((MultiThreadMatrixSoftwareModel) softwareModel).getThreadNumber()).putValue(OPERATION_NUMBER_PER_THREAD, lineNumberPerThread * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2).putValue(VALUE_COPY, matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).putValue(MEMORY_SIZE_MAIN, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).
                putValue(MEMORY_SIZE_PER_THREAD, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                        + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                        + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        return metrics;
    }

}
