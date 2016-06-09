package org.ixmas.ixmatrixmult.application.singlethread;

import org.ixmas.ixmatrixmult.application.Matrix;
import org.ixmas.ixmatrixmult.application.MatrixMultiplier;

import static com.google.common.base.Preconditions.checkArgument;

public class SingleThreadMatrixMultiplier implements MatrixMultiplier {

    @Override
    public Matrix multiply(Matrix m1, Matrix m2) {
        checkArgument(m1.getColumnNumber() == m2.getLineNumber());
        Matrix result = new Matrix(m1.getLineNumber(), m2.getColumnNumber());
        for (int lineIdx = 0; lineIdx < m1.getLineNumber(); lineIdx++) {
            for (int columnIdx = 0; columnIdx < m2.getColumnNumber(); columnIdx++) {
                Double value = 0.;
                for (int idx = 0; idx < m1.getColumnNumber(); idx++) {
                    value += m1.get(lineIdx, idx) * m2.get(idx, columnIdx);
                }
                result.set(lineIdx, columnIdx, value);
            }
        }
        return result;
    }

}
