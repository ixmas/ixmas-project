package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixMultiplierModel;
import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixOperationMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixMultiplierModel;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixOperationMetricsEvaluator;
import org.ixmas.ixmodel.improver.ModelAndEvaluator;
import org.ixmas.ixmodel.improver.ModelAndEvaluatorLister;

import static java.util.Arrays.asList;

public class MatrixOperationModelLister implements ModelAndEvaluatorLister {

    private final int m_auxiliaryNumber;

    public MatrixOperationModelLister(int auxiliaryNumber) {
        m_auxiliaryNumber = auxiliaryNumber;
    }

    @Override
    public Iterable<ModelAndEvaluator> list() {
        return asList(new ModelAndEvaluator(new SingleThreadMatrixMultiplierModel(), new SingleThreadMatrixOperationMetricsEvaluator()),
                new ModelAndEvaluator(new MultiThreadMatrixMultiplierModel(m_auxiliaryNumber), new MultiThreadMatrixOperationMetricsEvaluator()));
    }
}
