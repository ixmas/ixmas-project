package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.MetricsEvaluator;
import org.ixmas.ixmodel.metrics.Metrics;

public interface MatrixOperationMetricsEvaluator extends MetricsEvaluator<MatrixMultiplierModel, MatrixOperationInputModel> {

    @Override
    default Metrics evaluate(MatrixMultiplierModel model, MatrixOperationInputModel inputModel) {
        return evaluate(model, inputModel.getMatrixModel1(), inputModel.getMatrixModel2());
    }

    Metrics evaluate(MatrixMultiplierModel model, MatrixModel matrixModel1, MatrixModel matrixModel2);

}
