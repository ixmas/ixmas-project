package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.InputModel;
import org.ixmas.ixmodel.improver.MetricsEvaluator;
import org.ixmas.ixmodel.improver.Model;
import org.ixmas.ixmodel.metrics.Metrics;

public interface MatrixOperationMetricsEvaluator extends MetricsEvaluator {

    @Override
    default Metrics evaluate(Model model, InputModel inputModel) {
        return evaluate(model, ((MatrixOperationInputModel) inputModel).getMatrixModel1(), ((MatrixOperationInputModel) inputModel).getMatrixModel2());
    }

    Metrics evaluate(Model model, MatrixModel matrixModel1, MatrixModel matrixModel2);

}
