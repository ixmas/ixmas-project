package org.ixmas.ixmodel.metrics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MetricsValues {

    private Map<String, Double> m_values = new HashMap<>();

    public MetricsValues putValue(String dimension, Double value) {
        m_values.put(dimension, value);
        return this;
    }

    public MetricsValues putValue(String dimension, Integer value) {
        m_values.put(dimension, value.doubleValue());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetricsValues)) return false;
        MetricsValues that = (MetricsValues) o;
        return Objects.equals(m_values, that.m_values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_values);
    }

    @Override
    public String toString() {
        return "MetricsValues{" +
                "m_values=" + m_values +
                '}';
    }

    public Double getValue(String dimension) {
        return m_values.get(dimension);
    }
}
