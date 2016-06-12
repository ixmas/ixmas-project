package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.metrics.Metrics;

public interface MatrixMultiplierModel {

    Metrics evaluate(MatrixModel matrixModel1, MatrixModel matrixModel2);

}
