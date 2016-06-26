package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixModel;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixSoftwareMetrics.*;

public class MultiThreadMatrixMetricsEvaluatorTest {

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
        MultiThreadMatrixSoftwareModel multiThreadMatrixMultiplierModel = new MultiThreadMatrixSoftwareModel(threadNumber);
        MultiThreadMatrixSoftwareMetricsEvaluator multiThreadMatrixSoftwareMetricsEvaluator = new MultiThreadMatrixSoftwareMetricsEvaluator();
        int matrixModel1LineNumber = threadNumber * 8;
        int matrixModel1ColumnNumber = threadNumber * 8;
        int matrixModel2LineNumber = matrixModel1ColumnNumber;
        int matrixModel2ColumnNumber = threadNumber * 8;
        int lineNumberPerThread = matrixModel1LineNumber / threadNumber;
        if (lineNumberPerThread < 1) {
            lineNumberPerThread = 1;
        }
        MatrixModel matrixModel1 = new MatrixModel(matrixModel1LineNumber, matrixModel1ColumnNumber);
        MatrixModel matrixModel2 = new MatrixModel(matrixModel2LineNumber, matrixModel2ColumnNumber);
        Metrics metrics = multiThreadMatrixSoftwareMetricsEvaluator.evaluate(multiThreadMatrixMultiplierModel, matrixModel1, matrixModel2);
        Metrics expectedMetrics = new MultiThreadMatrixSoftwareMetrics();
        expectedMetrics.putValue(THREAD_NUMBER, threadNumber).putValue(OPERATION_NUMBER_PER_THREAD, lineNumberPerThread * matrixModel2.getColumnNumber() * matrixModel1.getColumnNumber() * 2).putValue(VALUE_COPY, matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).putValue(MEMORY_SIZE_MAIN, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber()).putValue(MEMORY_SIZE_PER_THREAD, matrixModel1.getLineNumber() * matrixModel1.getColumnNumber()//
                + matrixModel2.getLineNumber() * matrixModel2.getColumnNumber()
                + matrixModel1.getLineNumber() * matrixModel2.getColumnNumber());
        assertThat(metrics).as("THREAD_NUMBER = " + threadNumber).isEqualTo(expectedMetrics);
    }

}