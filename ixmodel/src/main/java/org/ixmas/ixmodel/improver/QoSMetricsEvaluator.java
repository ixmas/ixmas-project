package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.QoSMetrics;
import org.ixmas.ixmodel.metrics.SoftwareMetrics;

public interface QoSMetricsEvaluator {

    QoSMetrics evaluate(SoftwareMetrics softwareMetrics, HardwareModel hardwareModel);

}
