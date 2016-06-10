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
        List<Future<Matrix>> list = new ArrayList<>();
        int part = m1.getLineNumber() / threadNumber;
        if (part < 1) {
            part = 1;
        }
        for (int lineIdx = 0; lineIdx < m1.getLineNumber(); lineIdx += part) {
            Callable<Matrix> worker = new LineMultiplier(m1, m2, lineIdx, min(lineIdx + part, m1.getLineNumber()));
            Future<Matrix> submit = executor.submit(worker);
            list.add(submit);
        }
        int start = 0;
        Matrix lineResult;
        for (Future<Matrix> future : list) {
            try {
                lineResult = future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            for (int lineIdx = start; lineIdx < min(start + part, m1.getLineNumber()); lineIdx += 1) {
                result.setLine(lineIdx, lineResult.getLine(lineIdx));
            }
            start += part;
        }
        executor.shutdown();
        return result;
    }
}
