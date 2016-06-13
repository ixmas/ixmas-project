package org.ixmas.ixmodel.metrics;

import java.util.Map;
import java.util.Objects;

public class Metrics {

    private MetricsType m_metricsType;
    private MetricsValues m_metricsValues = new MetricsValues();

    public Metrics(MetricsType metricsType) {
        m_metricsType = metricsType;
    }

    public MetricsType getMetricsType() {
        return m_metricsType;
    }

    public MetricsValues getMetricsValues() {
        return m_metricsValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metrics)) return false;
        Metrics metrics = (Metrics) o;
        return Objects.equals(m_metricsType, metrics.m_metricsType) &&
                Objects.equals(m_metricsValues, metrics.m_metricsValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_metricsType, m_metricsValues);
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "m_metricsType=" + m_metricsType +
                ", m_metricsValues=" + m_metricsValues +
                '}';
    }

    /**
     * Comparison as partial order
     *
     * @param otherMetrics other metrics
     * @return -1 if less than otherMetrics, 0 if equal to, 1 if greater than, null if not comparable
     */
    public Integer compareWith(Metrics otherMetrics) {
        boolean isLessThan = true;
        boolean isEqualTo = true;
        boolean isGreaterThan = true;
        for (Map.Entry<String, Boolean> dimensionOrderEntry : m_metricsType.getOrderByDimension().entrySet()) {
            String dimension = dimensionOrderEntry.getKey();
            Boolean order = dimensionOrderEntry.getValue();

            Double value = m_metricsValues.getValue(dimension);
            Double otherValue = otherMetrics.getMetricsValues().getValue(dimension);
            if (!value.equals(otherValue)) {
                isEqualTo = false;
                if (value < otherValue) {
                    if (order) {
                        isGreaterThan = false;
                    } else {
                        isLessThan = false;
                    }
                } else if (value < otherValue) {
                    if (order) {
                        isLessThan = false;
                    } else {
                        isGreaterThan = false;
                    }
                }

            }
        }
        if (isEqualTo) {
            return 0;
        } else if (isLessThan) {
            return -1;
        } else if (isGreaterThan) {
            return 1;
        } else {
            return null;
        }
    }
}

