package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierMetrics;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SingleThreadMatrixMultiplierMetricsEvaluatorTest {

    @Test
    public void testEvaluate() throws Exception {
        SingleThreadMatrixOperationMetricsEvaluator singleThreadMatrixMultiplierModel = new SingleThreadMatrixOperationMetricsEvaluator();
        MatrixModel matrixModel1 = new MatrixModel(3, 2);
        MatrixModel matrixModel2 = new MatrixModel(2, 4);
        Metrics metrics = singleThreadMatrixMultiplierModel.evaluate(matrixModel1, matrixModel2);
        Metrics expectedMetrics = new MatrixMultiplierMetrics();
        expectedMetrics.getMetricsValues().putValue(MatrixMultiplierMetrics.operationNumber, 3 * 4 * 2 * 2).putValue(MatrixMultiplierMetrics.memorySize, 3 * 2 + 2 * 4 + 3 * 4);
        assertEquals(metrics, expectedMetrics);
    }

}