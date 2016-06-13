package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

public interface MetricsEvaluator<M, IM extends InputModel> {

    Metrics evaluate(M model, IM inputModel);

}
