package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixQoSMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixSoftwareMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.multithread.MultiThreadMatrixSoftwareModel;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixQoSMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixSoftwareMetricsEvaluator;
import org.ixmas.ixmatrixmult.improver.singlethread.SingleThreadMatrixSoftwareModel;
import org.ixmas.ixmodel.improver.ModelAndEvaluator;
import org.ixmas.ixmodel.improver.ModelAndEvaluatorLister;

import java.util.ArrayList;
import java.util.List;

public class MatrixModelLister implements ModelAndEvaluatorLister {

    @Override
    public Iterable<ModelAndEvaluator> list() {
        List<ModelAndEvaluator> modelAndEvaluators = new ArrayList<>();
        for (int coreNumber = 1; coreNumber <= 8; coreNumber++) {

            modelAndEvaluators.add(new ModelAndEvaluator(new SingleThreadMatrixSoftwareModel(), new MatrixHardwareModel(coreNumber), new SingleThreadMatrixQoSMetricsEvaluator(), new SingleThreadMatrixSoftwareMetricsEvaluator()));
            for (int threadNumber = 1; threadNumber <= 8; threadNumber++) {
                modelAndEvaluators.add(new ModelAndEvaluator(new MultiThreadMatrixSoftwareModel(threadNumber), new MatrixHardwareModel(coreNumber), new MultiThreadMatrixQoSMetricsEvaluator(), new MultiThreadMatrixSoftwareMetricsEvaluator()));
            }
        }
        return modelAndEvaluators;
    }

}
