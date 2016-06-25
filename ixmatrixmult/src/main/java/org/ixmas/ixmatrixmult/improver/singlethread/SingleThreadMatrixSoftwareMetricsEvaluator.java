package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixSoftwareMetricsEvaluator;
import org.ixmas.ixmodel.improver.SoftwareModel;
import org.ixmas.ixmodel.metrics.SoftwareMetrics;

import java.util.Objects;

import static org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixSoftwareMetrics.*;

public class SingleThreadMatrixSoftwareMetricsEvaluator implements MatrixSoftwareMetricsEvaluator {

    @Override
    public SoftwareMetrics evaluate(SoftwareModel softwareModel, MatrixModel matrixModel1, MatrixModel matrixModel2) {
        SoftwareMetrics metrics = new SingleThreadMatrixSoftwareMetrics();
        metrics.putValue(OPERATION_NUMBER, matrixModel1.getLineNumber() * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2).putValue(VALUE_COPY, 0).putValue(MEMORY_SIZE, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        return metrics;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(0);
    }


}
