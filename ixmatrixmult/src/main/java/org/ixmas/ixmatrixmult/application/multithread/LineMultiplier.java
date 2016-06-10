package org.ixmas.ixmatrixmult.application.multithread;

import org.ixmas.ixmatrixmult.application.Matrix;

import java.util.concurrent.Callable;

class LineMultiplier implements Callable<Matrix> {
    private Matrix m_result;
    private Matrix m_m1;
    private Matrix m_m2;
    private int m_start;
    private int m_end;

    LineMultiplier(Matrix m1, Matrix m2, int start, int end) {
        m_m1 = m1;
        m_m2 = m2;
        m_result = new Matrix(m1.getLineNumber(), m2.getColumnNumber());
        m_start = start;
        m_end = end;
    }

    @Override
    public Matrix call() {
        for (int lineIdx = m_start; lineIdx < m_end; lineIdx++) {
            for (int columnIdx = 0; columnIdx < m_m2.getColumnNumber(); columnIdx++) {
                Double value = 0.;
                for (int idx = 0; idx < m_m1.getColumnNumber(); idx++) {
                    value += m_m1.get(lineIdx, idx) * m_m2.get(idx, columnIdx);
                }
                m_result.set(lineIdx, columnIdx, value);
            }
        }
        return m_result;
    }
}