package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

public interface MetricsEvaluator {

    Metrics evaluate(Model model, InputModel inputModel);

}
