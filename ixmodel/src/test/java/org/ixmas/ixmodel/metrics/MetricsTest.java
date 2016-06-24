package org.ixmas.ixmodel.metrics;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ixmas.ixmodel.metrics.Order.Ascending;
import static org.ixmas.ixmodel.metrics.Order.Descending;

public class MetricsTest {

    @Test
    public void shouldCompareDifferentMetricsSameOrder() {
        MetricsType metricsType = new MetricsType("myMetricsType");
        String dimension1 = "dimension1";
        metricsType.putDimension(dimension1, Ascending);
        String dimension2 = "dimension2";
        metricsType.putDimension(dimension2, Ascending);
        Metrics metrics1 = new Metrics(metricsType);
        metrics1.putValue(dimension1, 10);
        metrics1.putValue(dimension2, 100);
        Metrics metrics2 = new Metrics(metricsType);
        metrics2.putValue(dimension1, 100);
        metrics2.putValue(dimension2, 1000);
        assertThat(metrics1.compareWith(metrics2)).isEqualTo(-1);
        assertThat(metrics2.compareWith(metrics1)).isEqualTo(1);
    }

    @Test
    public void shouldNotCompareDifferentMetricsSameOrder() {
        MetricsType metricsType = new MetricsType("myMetricsType");
        String dimension1 = "dimension1";
        metricsType.putDimension(dimension1, Ascending);
        String dimension2 = "dimension2";
        metricsType.putDimension(dimension2, Ascending);
        Metrics metrics1 = new Metrics(metricsType);
        metrics1.putValue(dimension1, 10);
        metrics1.putValue(dimension2, 100);
        Metrics metrics2 = new Metrics(metricsType);
        metrics2.putValue(dimension1, 1);
        metrics2.putValue(dimension2, 1000);
        assertThat(metrics1.compareWith(metrics2)).isNull();
        assertThat(metrics2.compareWith(metrics1)).isNull();
    }

    @Test
    public void shouldCompareDifferentMetricsInverseOrder() {
        MetricsType metricsType = new MetricsType("myMetricsType");
        String dimension1 = "dimension1";
        metricsType.putDimension(dimension1, Descending);
        String dimension2 = "dimension2";
        metricsType.putDimension(dimension2, Ascending);
        Metrics metrics1 = new Metrics(metricsType);
        metrics1.putValue(dimension1, 10);
        metrics1.putValue(dimension2, 100);
        Metrics metrics2 = new Metrics(metricsType);
        metrics2.putValue(dimension1, 1);
        metrics2.putValue(dimension2, 1000);
        assertThat(metrics1.compareWith(metrics2)).isEqualTo(-1);
        assertThat(metrics2.compareWith(metrics1)).isEqualTo(1);
    }

    @Test
    public void shouldNotCompareDifferentMetricsInverseOrder() {
        MetricsType metricsType = new MetricsType("myMetricsType");
        String dimension1 = "dimension1";
        metricsType.putDimension(dimension1, Descending);
        String dimension2 = "dimension2";
        metricsType.putDimension(dimension2, Ascending);
        Metrics metrics1 = new Metrics(metricsType);
        metrics1.putValue(dimension1, 10);
        metrics1.putValue(dimension2, 100);
        Metrics metrics2 = new Metrics(metricsType);
        metrics2.putValue(dimension1, 100);
        metrics2.putValue(dimension2, 1000);
        assertThat(metrics1.compareWith(metrics2)).isNull();
        assertThat(metrics2.compareWith(metrics1)).isNull();
    }

}
