package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.Metrics;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SingleThreadMatrixMultiplierModelTest {

    @Test
    public void testEvaluate() throws Exception {
        SingleThreadMatrixMultiplierModel singleThreadMatrixMultiplierModel = new SingleThreadMatrixMultiplierModel();
        MatrixModel matrixModel1 = new MatrixModel(3, 2);
        MatrixModel matrixModel2 = new MatrixModel(2, 4);
        Metrics metrics = singleThreadMatrixMultiplierModel.evaluate(matrixModel1, matrixModel2);
        Metrics expectedMetrics = new Metrics();
        expectedMetrics.increaseOperationNumber(3 * 4 * 2 * 2);
        assertEquals(metrics, expectedMetrics);
    }

}