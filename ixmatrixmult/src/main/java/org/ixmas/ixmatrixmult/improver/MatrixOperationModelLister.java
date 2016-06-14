package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixMultiplierModel;
import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixOperationMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixMultiplierModel;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixOperationMetricsEvaluator;
import org.ixmas.ixmodel.improver.ModelAndEvaluator;
import org.ixmas.ixmodel.improver.ModelAndEvaluatorLister;

import java.util.ArrayList;
import java.util.List;

public class MatrixOperationModelLister implements ModelAndEvaluatorLister<MatrixMultiplierModel, MatrixOperationInputModel> {

    @Override
    public Iterable<ModelAndEvaluator<MatrixMultiplierModel, MatrixOperationInputModel>> list() {
        List<ModelAndEvaluator<MatrixMultiplierModel, MatrixOperationInputModel>> modelAndEvaluators = new ArrayList<>();
        modelAndEvaluators.add(new ModelAndEvaluator<MatrixMultiplierModel, MatrixOperationInputModel>(new SingleThreadMatrixMultiplierModel(), new SingleThreadMatrixOperationMetricsEvaluator()));
//                new ModelAndEvaluator<MatrixMultiplierModel, MatrixOperationInputModel>(new SingleThreadMatrixMultiplierModel(), new SingleThreadMatrixOperationMetricsEvaluator()));
        for (int auxiliaryNumber = 1; auxiliaryNumber <= 8; auxiliaryNumber++) {
            modelAndEvaluators.add(new ModelAndEvaluator<MatrixMultiplierModel, MatrixOperationInputModel>(new MultiThreadMatrixMultiplierModel(auxiliaryNumber), new MultiThreadMatrixOperationMetricsEvaluator()));
        }
        return modelAndEvaluators;
    }

}
