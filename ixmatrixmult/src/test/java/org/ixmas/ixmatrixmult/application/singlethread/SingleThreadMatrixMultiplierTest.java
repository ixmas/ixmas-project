package org.ixmas.ixmatrixmult.application.singlethread;

import org.ixmas.ixmatrixmult.application.MatrixMultiplierTest;
import org.testng.annotations.DataProvider;

public class SingleThreadMatrixMultiplierTest extends MatrixMultiplierTest {

    @DataProvider(name = "getMatrixMultipliers")
    public Object[][] getMatrixMultipliers() {
        return new Object[][]{//
                new Object[]{"single case", new SingleThreadMatrixMultiplier()}};
    }


}
