package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.ModelImprover;
import org.ixmas.ixmodel.improver.ModelsByMetrics;
import org.ixmas.ixmodel.metrics.Metrics;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelImproverTest {

    @Test
    public void shouldFindNoComparableMetrics() {
        ModelImprover modelImprover = new ModelImprover(new MatrixOperationModelLister());
        ModelsByMetrics modelsByMetrics = modelImprover.bestModels(new MatrixOperationInputModel(new MatrixModel(2, 3), new MatrixModel(3, 4)));
        assertThat(modelsByMetrics.getMetricses()).isNotEmpty();
        for (Metrics metrics : modelsByMetrics.getMetricses()) {
            for (Metrics otherMetrics : modelsByMetrics.getMetricses()) {
                if (metrics != otherMetrics) {
                    assertThat(metrics.compareWith(otherMetrics)).as(metrics + "/" + otherMetrics).isNull();
                }
            }
        }
    }

}
