package org.ixmas.ixmatrixmult.application;

import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.System.nanoTime;
import static java.time.Duration.ofNanos;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class MatrixMultiplierTest {

    @Test(dataProvider = "getMatrixMultipliers")
    public void shouldComputeCorrectlyNullMatrix(String comment, MatrixMultiplier matrixMultiplier) {
        Matrix m1 = new Matrix(3, 2);
        Matrix m2 = new Matrix(2, 4);
        Matrix m1xm2 = matrixMultiplier.multiply(m1, m2);
        Matrix expectedM1xm2 = new Matrix(3, 4);
        assertThat(m1xm2).as(comment).isEqualTo(expectedM1xm2);
    }

    @Test(dataProvider = "getMatrixMultipliers")
    public void shouldComputeCorrectlyMatrix(String comment, MatrixMultiplier matrixMultiplier) {
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
        assertThat(m3).as(comment).isEqualTo(expectedM3);
    }

    @Test(dataProvider = "getMatrixMultipliers", enabled = false)
    public void shouldComputeCorrectlyLargeMatrix(String comment, MatrixMultiplier matrixMultiplier) {
        int size = 400;
        Matrix m1 = new Matrix(size, size);
        Matrix m2 = new Matrix(size, size);
        long before = nanoTime();
        Matrix m1xm2 = matrixMultiplier.multiply(m1, m2);
        long after = nanoTime();
        Duration duration = ofNanos(after - before);
        assertThat(m1xm2).as(comment + " duration=" + duration).isNull();

    }

}
