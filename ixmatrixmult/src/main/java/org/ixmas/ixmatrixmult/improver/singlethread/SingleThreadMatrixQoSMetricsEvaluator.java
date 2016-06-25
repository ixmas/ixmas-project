package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixHardwareModel;
import org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics;
import org.ixmas.ixmatrixmult.improver.MatrixQoSMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.MatrixSoftwareMetrics;
import org.ixmas.ixmodel.metrics.QoSMetrics;

import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.SPACE;
import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.TIME;
import static org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixSoftwareMetrics.*;

public class SingleThreadMatrixQoSMetricsEvaluator implements MatrixQoSMetricsEvaluator {


    @Override
    public QoSMetrics evaluate(MatrixSoftwareMetrics matrixSoftwareMetrics, MatrixHardwareModel matrixHardwareModel) {
        QoSMetrics qoSMetrics = new MatrixQoSMetrics();
        // space
        Double space = matrixSoftwareMetrics.getValue(MEMORY_SIZE);
        qoSMetrics.putValue(SPACE, space);
        // time
        Double time = matrixSoftwareMetrics.getValue(OPERATION_NUMBER);
        time += matrixSoftwareMetrics.getValue(VALUE_COPY);
        qoSMetrics.putValue(TIME, time);
        return qoSMetrics;
    }
}
