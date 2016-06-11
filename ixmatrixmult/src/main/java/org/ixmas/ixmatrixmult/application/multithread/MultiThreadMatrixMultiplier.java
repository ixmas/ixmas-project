package org.ixmas.ixmatrixmult.application.multithread;

import org.ixmas.ixmatrixmult.application.Matrix;
import org.ixmas.ixmatrixmult.application.MatrixMultiplier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.lang.Math.min;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class MultiThreadMatrixMultiplier implements MatrixMultiplier {

    private int threadNumber;

    public MultiThreadMatrixMultiplier(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public Matrix multiply(Matrix m1, Matrix m2) {
        Matrix result = new Matrix(m1.getLineNumber(), m2.getColumnNumber());
        ExecutorService executor = newFixedThreadPool(threadNumber);
        List<Future<Matrix>> matrixFutures = new ArrayList<>();
        int lineNumberPerThread = m1.getLineNumber() / threadNumber;
        if (lineNumberPerThread < 1) {
            lineNumberPerThread = 1;
        }
        for (int lineIdx = 0; lineIdx < m1.getLineNumber(); lineIdx += lineNumberPerThread) {
            Callable<Matrix> lineMultiplier = new LineMultiplier(m1, m2, lineIdx, min(lineIdx + lineNumberPerThread, m1.getLineNumber()));
            Future<Matrix> matrixFuture = executor.submit(lineMultiplier);
            matrixFutures.add(matrixFuture);
        }
        int start = 0;
        Matrix lineResult;
        for (Future<Matrix> matrixFuture : matrixFutures) {
            try {
                lineResult = matrixFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            for (int lineIdx = start; lineIdx < min(start + lineNumberPerThread, m1.getLineNumber()); lineIdx += 1) {
                result.setLine(lineIdx, lineResult.getLine(lineIdx));
            }
            start += lineNumberPerThread;
        }
        executor.shutdown();
        return result;
    }
}
