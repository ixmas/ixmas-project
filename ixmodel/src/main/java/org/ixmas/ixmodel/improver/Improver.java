package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

import java.util.Map;

public interface Improver {

    Map<MetricsEvaluator, Metrics> bestModels(InputModel inputModel);
}
