package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.SoftwareMetrics;

public interface SoftwareMetricsEvaluator {

    SoftwareMetrics evaluate(SoftwareModel softwareModel, InputModel inputModel);

}
