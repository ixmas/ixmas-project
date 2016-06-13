package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixOperationMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixOperationMetricsEvaluator;
import org.ixmas.ixmodel.improver.MetricsEvaluator;
import org.ixmas.ixmodel.improver.MetricsEvaluatorLister;

import static java.util.Arrays.asList;

public class MatrixOperationModelLister implements MetricsEvaluatorLister {

    private final int m_auxiliaryNumber;

    public MatrixOperationModelLister(int auxiliaryNumber) {
        m_auxiliaryNumber = auxiliaryNumber;
    }

    @Override
    public Iterable<MetricsEvaluator> list() {
        return asList(new SingleThreadMatrixOperationMetricsEvaluator(),
                new MultiThreadMatrixOperationMetricsEvaluator(m_auxiliaryNumber));
    }
}
