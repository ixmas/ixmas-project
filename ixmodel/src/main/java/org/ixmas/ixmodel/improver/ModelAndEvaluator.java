package org.ixmas.ixmodel.improver;

public class ModelAndEvaluator<M, IM extends InputModel> {

    private M model;
    private MetricsEvaluator<M, IM> m_metricsEvaluator;

    public ModelAndEvaluator(M model, MetricsEvaluator<M, IM> metricsEvaluator) {
        this.model = model;
        m_metricsEvaluator = metricsEvaluator;
    }

    public M getModel() {
        return model;
    }

    public MetricsEvaluator<M, IM> getMetricsEvaluator() {
        return m_metricsEvaluator;
    }
}
