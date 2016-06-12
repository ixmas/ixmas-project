package org.ixmas.ixmodel.metrics;

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
}
