package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.InputModel;
import org.ixmas.ixmodel.improver.SoftwareMetricsEvaluator;
import org.ixmas.ixmodel.improver.SoftwareModel;
import org.ixmas.ixmodel.metrics.SoftwareMetrics;

public interface MatrixSoftwareMetricsEvaluator extends SoftwareMetricsEvaluator {

    @Override
    default SoftwareMetrics evaluate(SoftwareModel softwareModel, InputModel inputModel) {
        return evaluate(softwareModel, ((MatrixInputModel) inputModel).getMatrixModel1(), ((MatrixInputModel) inputModel).getMatrixModel2());
    }

    SoftwareMetrics evaluate(SoftwareModel softwareModel, MatrixModel matrixModel1, MatrixModel matrixModel2);

}
