package org.ixmas.ixmatrixmult.application.multithread;

import org.ixmas.ixmatrixmult.application.MatrixMultiplierTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dependsOnGroups = {"MatrixMultiplierTest.*"})
public class MultiThreadMatrixMultiplierTest extends MatrixMultiplierTest {

    @DataProvider(name = "getMatrixMultipliers")
    public Object[][] getMatrixMultipliers() {
        int max = 8;
        Object[][] matrixMultipliers = new Object[max][];
        for (int threadNumber = 1; threadNumber <= max; threadNumber++) {
            matrixMultipliers[threadNumber - 1] = new Object[]{"THREAD_NUMBER=" + threadNumber, new MultiThreadMatrixMultiplier(threadNumber)};
        }
        return matrixMultipliers;
    }

}
