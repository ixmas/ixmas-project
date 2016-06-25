package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.QoSMetrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ModelsByMetrics {

    private Map<QoSMetrics, List<SoftwareModel>> m_modelsByMetrics = new HashMap<>();

    public void compareAndUpdate(QoSMetrics metrics, SoftwareModel softwareModel) {
        List<QoSMetrics> metricsToRemove = new ArrayList<>();
        boolean isToAdd = true;
        for (Entry<QoSMetrics, List<SoftwareModel>> metricsModelsEntry : m_modelsByMetrics.entrySet()) {
            QoSMetrics existingMetrics = metricsModelsEntry.getKey();
            List<SoftwareModel> existingSoftwareModels = metricsModelsEntry.getValue();
            Integer comparison = metrics.compareWith(existingMetrics);
            if (comparison != null) { // comparable
                if (comparison == -1) { // less than existing
                    isToAdd = false;
                    break;
                } else if (comparison == 1) { // greater than existing
                    isToAdd = true;
                    metricsToRemove.add(existingMetrics);
                } else { // same than existing
                    existingSoftwareModels.add(softwareModel);
                    isToAdd = false;
                    break;
                }
            }
        }
        if (isToAdd) {
            metricsToRemove.forEach(m_modelsByMetrics::remove);
            List<SoftwareModel> softwareModels = new ArrayList<>();
            softwareModels.add(softwareModel);
            m_modelsByMetrics.put(metrics, softwareModels);
        }
    }

    public Iterable<QoSMetrics> getMetricses() {
        return m_modelsByMetrics.keySet();
    }

    @Override
    public String toString() {
        return "ModelsByMetrics{" +
                "m_modelsByMetrics=" + m_modelsByMetrics +
                '}';
    }
}
