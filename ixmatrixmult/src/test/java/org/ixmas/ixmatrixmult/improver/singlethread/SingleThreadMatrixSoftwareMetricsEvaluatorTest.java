package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.Test;

import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.SPACE;
import static org.ixmas.ixmatrixmult.improver.MatrixQoSMetrics.TIME;
import static org.testng.Assert.assertEquals;

public class SingleThreadMatrixSoftwareMetricsEvaluatorTest {

    @Test
    public void testEvaluate() throws Exception {
        SingleThreadMatrixSoftwareModel singleThreadMatrixMultiplierModel = new SingleThreadMatrixSoftwareModel();
        SingleThreadMatrixSoftwareMetricsEvaluator singleThreadMatrixSoftwareMetricsEvaluator = new SingleThreadMatrixSoftwareMetricsEvaluator();
        MatrixModel matrixModel1 = new MatrixModel(3, 2);
        MatrixModel matrixModel2 = new MatrixModel(2, 4);
        Metrics metrics = singleThreadMatrixSoftwareMetricsEvaluator.evaluate(singleThreadMatrixMultiplierModel, matrixModel1, matrixModel2);
        Metrics expectedMetrics = new MatrixQoSMetrics();
        expectedMetrics.putValue(TIME, 3 * 4 * 2 * 2).putValue(SPACE, 3 * 2 + 2 * 4 + 3 * 4);
        assertEquals(metrics, expectedMetrics);
    }

}