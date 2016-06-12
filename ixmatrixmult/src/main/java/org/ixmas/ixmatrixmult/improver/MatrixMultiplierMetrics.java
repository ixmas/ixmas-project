package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.metrics.Metrics;
import org.ixmas.ixmodel.metrics.MetricsType;

public class MatrixMultiplierMetrics extends Metrics {

    public static final String operationNumber = "m_operationNumber";
    public static final String operationNumberPerAuxiliary = "m_operationNumber";
    public static final String valueCopy = "m_operationNumber";
    public static final String valueCopyPerAuxiliary = "m_operationNumber";
    public static final String memorySize = "m_operationNumber";
    public static final String memorySizePerAuxiliary = "m_operationNumber";

    public MatrixMultiplierMetrics() {
        super(new MetricsType("MatrixMultiplier").putDimension(operationNumber, false).putDimension(operationNumberPerAuxiliary, false).putDimension(valueCopy, false).putDimension(valueCopyPerAuxiliary, false).putDimension(memorySize, false).putDimension(memorySizePerAuxiliary, false));
    }

}
