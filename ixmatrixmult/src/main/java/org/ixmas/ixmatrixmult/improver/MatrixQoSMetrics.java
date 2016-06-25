package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.metrics.MetricsType;
import org.ixmas.ixmodel.metrics.QoSMetrics;

import static org.ixmas.ixmodel.metrics.Order.Descending;

public class MatrixQoSMetrics extends QoSMetrics {

    public static final String TIME = "TIME";
    public static final String SPACE = "SPACE";

    public MatrixQoSMetrics() {
        super(new MetricsType("MatrixQoSMetrics").putDimension(TIME, Descending).putDimension(SPACE, Descending));
    }

}
