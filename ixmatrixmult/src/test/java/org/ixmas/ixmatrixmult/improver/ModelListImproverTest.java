package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.MetricsEvaluator;
import org.ixmas.ixmodel.improver.ModelListImprover;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.Test;

import java.util.Map;

public class ModelListImproverTest {

    @Test
    public void should() {
        ModelListImprover modelListImprover = new ModelListImprover(new MatrixOperationModelLister());
        Map<MetricsEvaluator, Metrics> metricsByMetricsEvaluator = modelListImprover.bestModels(new MatrixOperationInputModel(new MatrixModel(2, 3), new MatrixModel(3, 4)));

    }
}
