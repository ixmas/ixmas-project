package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.Metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ModelsByMetrics {

    private Map<Metrics, List<Model>> m_modelsByMetrics = new HashMap<>();

    public void compareAndUpdate(Metrics metrics, Model model) {
        List<Metrics> metricsToRemove = new ArrayList<>();
        boolean isToAdd = true;
        for (Entry<Metrics, List<Model>> metricsModelsEntry : m_modelsByMetrics.entrySet()) {
            Metrics existingMetrics = metricsModelsEntry.getKey();
            List<Model> existingModels = metricsModelsEntry.getValue();
            Integer comparison = metrics.compareWith(existingMetrics);
            if (comparison != null) { // comparable
                if (comparison == -1) { // less than existing
                    isToAdd = false;
                    break;
                } else if (comparison == 1) { // greater than existing
                    isToAdd = true;
                    metricsToRemove.add(existingMetrics);
                } else { // same than existing
                    existingModels.add(model);
                    isToAdd = false;
                    break;
                }
            }
        }
        if (isToAdd) {
            metricsToRemove.forEach(m_modelsByMetrics::remove);
            List<Model> models = new ArrayList<>();
            models.add(model);
            m_modelsByMetrics.put(metrics, models);
        }
    }

    public Iterable<Metrics> getMetricses() {
        return m_modelsByMetrics.keySet();
    }

    @Override
    public String toString() {
        return "ModelsByMetrics{" +
                "m_modelsByMetrics=" + m_modelsByMetrics +
                '}';
    }
}
