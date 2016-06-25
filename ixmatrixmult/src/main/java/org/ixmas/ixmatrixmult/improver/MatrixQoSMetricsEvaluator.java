package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.HardwareModel;
import org.ixmas.ixmodel.improver.QoSMetricsEvaluator;
import org.ixmas.ixmodel.metrics.QoSMetrics;
import org.ixmas.ixmodel.metrics.SoftwareMetrics;

public interface MatrixQoSMetricsEvaluator extends QoSMetricsEvaluator {

    @Override
    default QoSMetrics evaluate(SoftwareMetrics softwareMetrics, HardwareModel hardwareModel) {
        return evaluate((MatrixSoftwareMetrics) softwareMetrics, (MatrixHardwareModel) hardwareModel);
    }

    QoSMetrics evaluate(MatrixSoftwareMetrics matrixSoftwareMetrics, MatrixHardwareModel matrixHardwareModel);

}
