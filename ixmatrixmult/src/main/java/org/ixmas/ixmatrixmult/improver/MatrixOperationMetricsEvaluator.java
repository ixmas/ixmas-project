package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.MetricsEvaluator;
import org.ixmas.ixmodel.metrics.Metrics;

public interface MatrixOperationMetricsEvaluator<M> extends MetricsEvaluator<M, MatrixOperationInputModel> {

    @Override
    default Metrics evaluate(M model, MatrixOperationInputModel inputModel) {
        return evaluate(model, inputModel.getMatrixModel1(), inputModel.getMatrixModel2());
    }

    Metrics evaluate(M model, MatrixModel matrixModel1, MatrixModel matrixModel2);

}
