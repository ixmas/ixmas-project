package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

public class ModelImprover implements Improver {

    private ModelAndEvaluatorLister m_modelAndEvaluatorLister;

    public ModelImprover(ModelAndEvaluatorLister modelAndEvaluatorLister) {
        m_modelAndEvaluatorLister = modelAndEvaluatorLister;
    }

    @Override
    public ModelsByMetrics bestModels(InputModel inputModel) {
        ModelsByMetrics modelsByMetrics = new ModelsByMetrics();
        for (ModelAndEvaluator modelAndEvaluator : m_modelAndEvaluatorLister.list()) {
            Model model = modelAndEvaluator.getModel();
            MetricsEvaluator metricsEvaluator = modelAndEvaluator.getMetricsEvaluator();
            Metrics metrics = metricsEvaluator.evaluate(model, inputModel);
            modelsByMetrics.compareAndUpdate(metrics, model);
        }
        return modelsByMetrics;
    }

}