package org.ixmas.ixmodel.improver;

public interface ModelAndEvaluatorLister<M extends Model, IM extends InputModel> {

    Iterable<ModelAndEvaluator<M, IM>> list();
}
