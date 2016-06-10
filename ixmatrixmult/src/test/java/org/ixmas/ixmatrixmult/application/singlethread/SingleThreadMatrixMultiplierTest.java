package org.ixmas.ixmatrixmult.application.singlethread;

import org.ixmas.ixmatrixmult.application.Matrix;
import org.ixmas.ixmatrixmult.application.MatrixMultiplier;
import org.ixmas.ixmatrixmult.application.MatrixMultiplierTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleThreadMatrixMultiplierTest extends MatrixMultiplierTest {

    @Override
    public MatrixMultiplier getMatrixMultiplier() {
        return new SingleThreadMatrixMultiplier();
    }

}
