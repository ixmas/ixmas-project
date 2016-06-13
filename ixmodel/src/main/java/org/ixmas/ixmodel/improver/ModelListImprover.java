package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelListImprover implements Improver {

    private MetricsEvaluatorLister m_metricsEvaluatorLister;

    public ModelListImprover(MetricsEvaluatorLister metricsEvaluatorLister) {
        m_metricsEvaluatorLister = metricsEvaluatorLister;
    }

    @Override
    public Map<MetricsEvaluator, Metrics> bestModels(InputModel inputModel) {
        Map<MetricsEvaluator, Metrics> metricsByMetricsEvaluator = new HashMap<>();
        for (MetricsEvaluator metricsEvaluator : m_metricsEvaluatorLister.list()) {
            Metrics metrics = metricsEvaluator.evaluate(inputModel);
            compareAndUpdate(metrics, metricsEvaluator, metricsByMetricsEvaluator);
        }
        return metricsByMetricsEvaluator;
    }

    private void compareAndUpdate(Metrics metrics, MetricsEvaluator metricsEvaluator, Map<MetricsEvaluator, Metrics> metricsByModel) {
        List<MetricsEvaluator> metricsEvaluatorsToRemove = new ArrayList<>();
        boolean isToAdd = false;
        for (Map.Entry<MetricsEvaluator, Metrics> metricsEvaluatorMetricsEntry : metricsByModel.entrySet()) {
            MetricsEvaluator existingMetricsEvaluator = metricsEvaluatorMetricsEntry.getKey();
            Metrics existingMetrics = metricsEvaluatorMetricsEntry.getValue();
            Integer comparison = metrics.compareWith(existingMetrics);
            if (comparison != null) { // comparable
                if (comparison == -1) { //
                    isToAdd = false;
                    break;
                } else if (comparison == 1) {
                    isToAdd = true;
                    metricsEvaluatorsToRemove.add(existingMetricsEvaluator);
                } else {
                    // TODO: manage equality
                }
            }
        }
        if (isToAdd) {
            metricsEvaluatorsToRemove.forEach(metricsByModel::remove);
            metricsByModel.put(metricsEvaluator, metrics);
        }
    }

}