package org.ixmas.ixmodel.metrics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MetricsType {

    private String m_name;
    private Map<String, Boolean> m_orderByDimension = new HashMap<>();

    public MetricsType(String name) {
        m_name = name;
    }

    public MetricsType putDimension(String dimension, boolean order) {
        m_orderByDimension.put(dimension, order);
        return this;
    }

    public MetricsType putDimension(String dimension) {
        return putDimension(dimension, true);
    }

    public Map<String, Boolean> getOrderByDimension() {
        return m_orderByDimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetricsType)) return false;
        MetricsType that = (MetricsType) o;
        return Objects.equals(m_name, that.m_name) &&
                Objects.equals(m_orderByDimension, that.m_orderByDimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_name, m_orderByDimension);
    }

    @Override
    public String toString() {
        return "MetricsType{" +
                "m_name='" + m_name + '\'' +
                ", m_orderByDimension=" + m_orderByDimension +
                '}';
    }
}
