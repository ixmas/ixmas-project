package org.ixmas.ixmodel.improver;

public class ModelAndEvaluator {

    private Model model;
    private MetricsEvaluator m_metricsEvaluator;

    public ModelAndEvaluator(Model model, MetricsEvaluator metricsEvaluator) {
        this.model = model;
        m_metricsEvaluator = metricsEvaluator;
    }

    public Model getModel() {
        return model;
    }

    public MetricsEvaluator getMetricsEvaluator() {
        return m_metricsEvaluator;
    }
}
