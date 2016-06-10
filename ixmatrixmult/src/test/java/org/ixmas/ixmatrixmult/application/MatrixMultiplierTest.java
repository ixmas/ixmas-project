package org.ixmas.ixmatrixmult.application;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class MatrixMultiplierTest {

    public abstract MatrixMultiplier getMatrixMultiplier();

    @Test
    public void shouldComputeCorrectlyNullMatrix() {
        MatrixMultiplier matrixMultiplier = getMatrixMultiplier();
        Matrix m1 = new Matrix(3, 2);
        Matrix m2 = new Matrix(2, 4);
        Matrix m1xm2 = matrixMultiplier.multiply(m1, m2);
        Matrix expectedM1xm2 = new Matrix(3, 4);
        assertThat(m1xm2).isEqualTo(expectedM1xm2);
    }

    @Test
    public void shouldComputeCorrectlyMatrix() {
        MatrixMultiplier matrixMultiplier = getMatrixMultiplier();
        Matrix m1 = new Matrix(3, 2);
        Double[][] values1 = {{2., 3.}, {4., 5.}, {6., 7.}};
        m1.setValues(values1);
        Matrix m2 = new Matrix(2, 4);
        Double[][] values2 = {{8., 9., 10., 11.}, {12., 13., 14., 15.}};
        m2.setValues(values2);
        Matrix m3 = matrixMultiplier.multiply(m1, m2);
        Matrix expectedM3 = new Matrix(3, 4);
        Double[][] values3 = {{52.0, 57.0, 62.0, 67.0}, {92.0, 101.0, 110.0, 119.0}, {132.0, 145.0, 158.0, 171.0}};
        expectedM3.setValues(values3);
        assertThat(m3).isEqualTo(expectedM3);
    }

}
