package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.metrics.Metrics;
import org.ixmas.ixmodel.metrics.MetricsType;

import static org.ixmas.ixmodel.metrics.Order.Descending;

public class MatrixMultiplierMetrics extends Metrics {

    public static final String operationNumber = "operationNumber";
    public static final String operationNumberPerAuxiliary = "operationNumberPerAuxiliary";
    public static final String valueCopy = "valueCopy";
    public static final String valueCopyPerAuxiliary = "valueCopyPerAuxiliary";
    public static final String memorySize = "memorySize";
    public static final String memorySizePerAuxiliary = "memorySizePerAuxiliary";

    public MatrixMultiplierMetrics() {
        super(new MetricsType("MatrixMultiplier").putDimension(operationNumber, Descending).putDimension(operationNumberPerAuxiliary, Descending).putDimension(valueCopy, Descending).putDimension(valueCopyPerAuxiliary, Descending).putDimension(memorySize, Descending).putDimension(memorySizePerAuxiliary, Descending));
    }

}
