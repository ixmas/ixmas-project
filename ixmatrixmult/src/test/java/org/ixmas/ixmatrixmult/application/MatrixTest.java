package org.ixmas.ixmatrixmult.application;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixTest {

    @Test
    public void shouldGetTheRightValueForMatrixSize1() {
        Matrix m = new Matrix(1, 1);
        assertThat(m.get(0, 0)).isEqualTo(0.);
        m.set(0, 0, 42.);
        assertThat(m.get(0, 0)).isEqualTo(42.);
    }

    @Test
    public void shouldGetTheRightValueForMatrixSize2x2() {
        Matrix m = new Matrix(2, 2);
        m.set(0, 0, 12.);
        m.set(0, 1, 34.);
        m.set(1, 0, 56.);
        m.set(1, 1, 78.);
        assertThat(m.get(0, 0)).isEqualTo(12.);
        assertThat(m.get(0, 1)).isEqualTo(34.);
        assertThat(m.get(1, 0)).isEqualTo(56.);
        assertThat(m.get(1, 1)).isEqualTo(78.);
    }

    @Test
    public void shouldGetTheRightValueForMatrixSize2x3() {
        Matrix m = new Matrix(2, 3);
        m.set(0, 0, 12.);
        m.set(0, 1, 34.);
        m.set(0, 2, 56.);
        m.set(1, 0, 78.);
        m.set(1, 1, 90.);
        m.set(1, 2, 101.);
        assertThat(m.get(0, 0)).isEqualTo(12.);
        assertThat(m.get(0, 1)).isEqualTo(34.);
        assertThat(m.get(0, 2)).isEqualTo(56.);
        assertThat(m.get(1, 0)).isEqualTo(78.);
        assertThat(m.get(1, 1)).isEqualTo(90.);
        assertThat(m.get(1, 2)).isEqualTo(101.);
    }

}
