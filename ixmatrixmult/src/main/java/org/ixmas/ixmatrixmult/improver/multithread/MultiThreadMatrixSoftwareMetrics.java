package org.ixmas.ixmatrixmult.improver.multithread;

import org.ixmas.ixmatrixmult.improver.MatrixSoftwareMetrics;
import org.ixmas.ixmodel.metrics.MetricsType;

import static org.ixmas.ixmodel.metrics.Order.Descending;

public class MultiThreadMatrixSoftwareMetrics extends MatrixSoftwareMetrics {

    public static final String THREAD_NUMBER = "THREAD_NUMBER";
    public static final String OPERATION_NUMBER_PER_THREAD = "OPERATION_NUMBER_PER_THREAD";
    public static final String VALUE_COPY = "VALUE_COPY";
    public static final String MEMORY_SIZE_MAIN = "MEMORY_SIZE_MAIN";
    public static final String MEMORY_SIZE_PER_THREAD = "MEMORY_SIZE_PER_THREAD";

    public MultiThreadMatrixSoftwareMetrics() {
        super(new MetricsType("MultiThreadMatrixSoftwareMetrics").putDimension(THREAD_NUMBER, Descending).putDimension(OPERATION_NUMBER_PER_THREAD, Descending).putDimension(VALUE_COPY, Descending).putDimension(MEMORY_SIZE_MAIN, Descending).putDimension(MEMORY_SIZE_PER_THREAD, Descending));
    }

}
