package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixHardwareModel;
import org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics;
import org.ixmas.ixmatrixmult.improver.MatrixQoSMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.MatrixSoftwareMetrics;
import org.ixmas.ixmodel.metrics.QoSMetrics;

import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.SPACE;
import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.TIME;
import static org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixSoftwareMetrics.*;

public class MultiThreadMatrixQoSMetricsEvaluator implements MatrixQoSMetricsEvaluator {


    @Override
    public QoSMetrics evaluate(MatrixSoftwareMetrics matrixSoftwareMetrics, MatrixHardwareModel matrixHardwareModel) {
        QoSMetrics qoSMetrics = new MatrixQoSMetrics();
        int coreNumber = matrixHardwareModel.getCoreNumber();
        Double threadNumber = matrixSoftwareMetrics.getValue(THREAD_NUMBER);
        // space
        Double space = matrixSoftwareMetrics.getValue(MEMORY_SIZE_MAIN);
        space += matrixSoftwareMetrics.getValue(MEMORY_SIZE_PER_THREAD) * threadNumber;
        qoSMetrics.putValue(SPACE, space);
        // time
        double time = matrixSoftwareMetrics.getValue(OPERATION_NUMBER_PER_THREAD) * threadNumber / coreNumber;
        time += matrixSoftwareMetrics.getValue(VALUE_COPY);
        qoSMetrics.putValue(TIME, time);
        return qoSMetrics;
    }
}
