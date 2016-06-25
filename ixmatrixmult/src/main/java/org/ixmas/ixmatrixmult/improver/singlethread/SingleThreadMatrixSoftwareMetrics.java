package org.ixmas.ixmatrixmult.improver.singlethread;

import org.ixmas.ixmatrixmult.improver.MatrixSoftwareMetrics;
import org.ixmas.ixmodel.metrics.MetricsType;

import static org.ixmas.ixmodel.metrics.Order.Descending;

public class SingleThreadMatrixSoftwareMetrics extends MatrixSoftwareMetrics {

    public static final String OPERATION_NUMBER = "OPERATION_NUMBER";
    public static final String VALUE_COPY = "VALUE_COPY";
    public static final String MEMORY_SIZE = "MEMORY_SIZE";

    public SingleThreadMatrixSoftwareMetrics() {
        super(new MetricsType("SingleThreadMatrixSoftwareMetrics").putDimension(OPERATION_NUMBER, Descending).putDimension(VALUE_COPY, Descending).putDimension(MEMORY_SIZE, Descending));
    }

}
