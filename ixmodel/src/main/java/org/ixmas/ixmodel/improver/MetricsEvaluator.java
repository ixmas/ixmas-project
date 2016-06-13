package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

public interface MetricsEvaluator<IM extends InputModel> {

    Metrics evaluate(IM inputModel);

}
