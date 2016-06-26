package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixHardwareModel;
import org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics;
import org.ixmas.ixmodel.improver.HardwareModel;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.Test;

import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.SPACE;
import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.TIME;
import static org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixSoftwareMetrics.*;
import static org.testng.Assert.assertEquals;

public class SingleThreadMatrixQoSMetricsEvaluatorTest {

    @Test
    public void shouldComputeQosMetricsCorrectly() throws Exception {
        SingleThreadMatrixQoSMetricsEvaluator singleThreadMatrixQoSMetricsEvaluator = new SingleThreadMatrixQoSMetricsEvaluator();
        SingleThreadMatrixSoftwareMetrics singleThreadMatrixSoftwareMetrics = new SingleThreadMatrixSoftwareMetrics();
        singleThreadMatrixSoftwareMetrics.putValue(VALUE_COPY, 7).putValue(OPERATION_NUMBER, 13).putValue(MEMORY_SIZE, 23);
        HardwareModel hardwareModel = new MatrixHardwareModel(8);
        Metrics metrics = singleThreadMatrixQoSMetricsEvaluator.evaluate(singleThreadMatrixSoftwareMetrics, hardwareModel);
        Metrics expectedMetrics = new MatrixQoSMetrics();
        expectedMetrics.putValue(TIME, 7 + 13).putValue(SPACE, 23);
        assertEquals(metrics, expectedMetrics);
    }

}