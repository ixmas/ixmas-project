package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

import java.util.Map;

public interface Improver<M extends Model, IM extends InputModel> {

    Map<M, Metrics> bestModels(IM inputModel);
}
