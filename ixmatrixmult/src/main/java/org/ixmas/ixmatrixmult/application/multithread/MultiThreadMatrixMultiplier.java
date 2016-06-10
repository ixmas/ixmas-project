package org.ixmas.ixmatrixmult.application.multithread;

import java.util.concurrent.*;
import org.ixmas.ixmatrixmult.application.Matrix;
import org.ixmas.ixmatrixmult.application.MatrixMultiplier;

import static com.google.common.base.Preconditions.checkArgument;

public class MultiThreadMatrixMultiplier implements MatrixMultiplier {

    private int threadNumber;

    public MultiThreadMatrixMultiplier(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public Matrix multiply(Matrix m1, Matrix m2) {
        checkArgument(m1.getColumnNumber() == m2.getLineNumber());
        Matrix result = new Matrix(m1.getLineNumber(), m2.getColumnNumber());
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadNumber);
        for (int lineIdx = 0; lineIdx < m1.getLineNumber(); lineIdx++) {
            int finalLineIdx = lineIdx;
            ForkJoinTask<Boolean> forkJoinTask = new ForkJoinTask<Boolean>() {
                @Override
                public Boolean getRawResult() {
                    return null;  // TODO implement method
                }

                @Override
                protected void setRawResult(Boolean value) {
                    // TODO implement method
                }

                @Override
                protected boolean exec() {
                    for (int columnIdx = 0; columnIdx < m2.getColumnNumber(); columnIdx++) {
                        Double value = 0.;
                        for (int idx = 0; idx < m1.getColumnNumber(); idx++) {
                            value += m1.get(finalLineIdx, idx) * m2.get(idx, columnIdx);
                        }
                        result.set(finalLineIdx, columnIdx, value);
                    }
                    return true;
                }
            };
        }
        return result;
    }
}
