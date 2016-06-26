package org.ixmas.ixmodel.metrics;

import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.ixmas.ixmodel.metrics.Order.Ascending;

public class Metrics {

    private MetricsType m_metricsType;
    private MetricsValues m_metricsValues = new MetricsValues();

    public Metrics(MetricsType metricsType) {
        m_metricsType = metricsType;
    }

    public MetricsType getMetricsType() {
        return m_metricsType;
    }

    public Double getValue(String dimension) {
        return m_metricsValues.getValue(dimension);
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
        checkNotNull(otherMetrics);
        checkArgument(otherMetrics.getMetricsType().equals(m_metricsType), "Cannot compare metrics %s with other metrics %s", m_metricsType.getName(), otherMetrics.getMetricsType().getName());
        boolean isLessThan = true;
        boolean isEqualTo = true;
        boolean isGreaterThan = true;
        for (Map.Entry<String, Order> dimensionOrderEntry : m_metricsType.getOrderByDimension().entrySet()) {
            String dimension = dimensionOrderEntry.getKey();
            Order order = dimensionOrderEntry.getValue();

            Double value = m_metricsValues.getValue(dimension);
            Double otherValue = otherMetrics.m_metricsValues.getValue(dimension);
            if (!(value == null && otherValue == null)) {
                isEqualTo = false;
                if (value == null || otherValue == null) {
                    isGreaterThan = false;
                    isLessThan = false;
                    break;
                }
                if (!value.equals(otherValue)) {
                    if (value < otherValue) {
                        if (order == Ascending) {
                            isGreaterThan = false;
                        } else {
                            isLessThan = false;
                        }
                    } else { // if (value > otherValue) {
                        if (order == Ascending) {
                            isLessThan = false;
                        } else {
                            isGreaterThan = false;
                        }
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

    public Metrics putValue(String dimension, Integer value) {
        checkArgument(m_metricsType.containsDimension(dimension), "Dimension %s does not exist in %s", dimension, m_metricsType.getName());
        m_metricsValues.putValue(dimension, value);
        return this;
    }

    public Metrics putValue(String dimension, Double value) {
        checkArgument(m_metricsType.containsDimension(dimension));
        m_metricsValues.putValue(dimension, value);
        return this;
    }

}

