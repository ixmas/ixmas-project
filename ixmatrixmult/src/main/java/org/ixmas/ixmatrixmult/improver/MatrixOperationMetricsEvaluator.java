package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.MetricsEvaluator;
import org.ixmas.ixmodel.metrics.Metrics;

public interface MatrixOperationMetricsEvaluator extends MetricsEvaluator<MatrixOperationInputModel> {

    @Override
    default Metrics evaluate(MatrixOperationInputModel inputModel) {
        return evaluate(inputModel.getMatrixModel1(), inputModel.getMatrixModel2());
    }

    Metrics evaluate(MatrixModel matrixModel1, MatrixModel matrixModel2);

}
