package org.ixmas.ixmatrixmult.improver;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixOperationModelListerTest {

    @Test
    public void should() {
        MatrixModelLister matrixModelLister = new MatrixModelLister();
        final int[] count = {0};
        matrixModelLister.list().forEach(modelAndEvaluator -> count[0]++);
        assertThat(count[0]).isEqualTo(9);
    }
}
