package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmatrixmult.improver.MatrixMultiplierMetrics;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiThreadMatrixMultiplierModelTest {

    private static final int maxThreadNumber = 8;


    @DataProvider(name = "getThreadNumber")
    public Object[][] getThreadNumber() {
        Object[][] result = new Object[maxThreadNumber][];
        for (int threadNumber = 1; threadNumber <= maxThreadNumber; threadNumber++) {
            result[threadNumber - 1] = new Object[]{threadNumber};
        }
        return result;
    }

    @Test(dataProvider = "getThreadNumber")
    public void testEvaluate(int threadNumber) {
        MultiThreadMatrixMultiplierModel multiThreadMatrixMultiplierModel = new MultiThreadMatrixMultiplierModel(threadNumber);
        int matrixModel1LineNumber = threadNumber * 8;
        int matrixModel1ColumnNumber = threadNumber * 8;
        int matrixModel2LineNumber = matrixModel1ColumnNumber;
        int matrixModel2ColumnNumber = threadNumber * 8;
        int lineNumberPerAuxiliary = matrixModel1LineNumber / threadNumber;
        if (lineNumberPerAuxiliary < 1) {
            lineNumberPerAuxiliary = 1;
        }
        MatrixModel matrixModel1 = new MatrixModel(matrixModel1LineNumber, matrixModel1ColumnNumber);
        MatrixModel matrixModel2 = new MatrixModel(matrixModel2LineNumber, matrixModel2ColumnNumber);
        Metrics metrics = multiThreadMatrixMultiplierModel.evaluate(matrixModel1, matrixModel2);
        Metrics expectedMetrics = new MatrixMultiplierMetrics();
        expectedMetrics.getMetricsValues().putValue(MatrixMultiplierMetrics.operationNumberPerAuxiliary, lineNumberPerAuxiliary * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2).putValue(MatrixMultiplierMetrics.valueCopy, matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).putValue(MatrixMultiplierMetrics.memorySize, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).putValue(MatrixMultiplierMetrics.memorySizePerAuxiliary, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        assertThat(metrics).as("threadNumber = " + threadNumber).isEqualTo(expectedMetrics);
    }

}