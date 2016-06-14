package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelListImprover<M extends Model, IM extends InputModel> implements Improver<M, IM> {

    private ModelAndEvaluatorLister<M, IM> m_modelAndEvaluatorLister;

    public ModelListImprover(ModelAndEvaluatorLister<M, IM> modelAndEvaluatorLister) {
        m_modelAndEvaluatorLister = modelAndEvaluatorLister;
    }

    @Override
    public Map<M, Metrics> bestModels(IM inputModel) {
        Map<M, Metrics> modelByMetricsEvaluator = new HashMap<>();
        for (ModelAndEvaluator<M, IM> modelAndEvaluator : m_modelAndEvaluatorLister.list()) {
            M model = modelAndEvaluator.getModel();
            MetricsEvaluator metricsEvaluator = modelAndEvaluator.getMetricsEvaluator();
            Metrics metrics = metricsEvaluator.evaluate(model, inputModel);
            compareAndUpdate(metrics, model, modelByMetricsEvaluator);
        }
        return modelByMetricsEvaluator;
    }

    private void compareAndUpdate(Metrics metrics, M model, Map<M, Metrics> metricsByModel) {
        List<M> modelsToRemove = new ArrayList<>();
        boolean isToAdd = true;
        for (Map.Entry<M, Metrics> modelMetricsEntry : metricsByModel.entrySet()) {
            M existingModel = modelMetricsEntry.getKey();
            Metrics existingMetrics = modelMetricsEntry.getValue();
            Integer comparison = metrics.compareWith(existingMetrics);
            if (comparison != null) { // comparable
                if (comparison == -1) { //
                    isToAdd = false;
                    break;
                } else if (comparison == 1) {
                    isToAdd = true;
                    modelsToRemove.add(existingModel);
                } else {
                    // TODO: manage equality
                }
            }
        }
        if (isToAdd) {
            modelsToRemove.forEach(metricsByModel::remove);
            metricsByModel.put(model, metrics);
        }
    }

}