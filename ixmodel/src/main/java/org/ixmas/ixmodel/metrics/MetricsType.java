package org.ixmas.ixmodel.metrics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.ixmas.ixmodel.metrics.Order.Ascending;

public class MetricsType {

    private String m_name;
    private Map<String, Order> m_orderByDimension = new HashMap<>();

    public MetricsType(String name) {
        m_name = name;
    }

    public MetricsType putDimension(String dimension, Order order) {
        checkNotNull(dimension);
        checkNotNull(order);
        checkArgument(!m_orderByDimension.containsKey(dimension), "Dimension %s already put", dimension);
        m_orderByDimension.put(dimension, order);
        return this;
    }

    public MetricsType putDimension(String dimension) {
        return putDimension(dimension, Ascending);
    }

    public Map<String, Order> getOrderByDimension() {
        return m_orderByDimension;
    }

    public String getName() {
        return m_name;
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

    public boolean containsDimension(String dimension) {
        return m_orderByDimension.containsKey(dimension);
    }
}
