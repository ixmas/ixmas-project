package org.ixmas.ixmodel.improver;

import org.ixmas.ixmodel.metrics.QoSMetrics;
import org.ixmas.ixmodel.metrics.SoftwareMetrics;

public class ModelImprover implements Improver {

    private ModelAndEvaluatorLister m_modelAndEvaluatorLister;

    public ModelImprover(ModelAndEvaluatorLister modelAndEvaluatorLister) {
        m_modelAndEvaluatorLister = modelAndEvaluatorLister;
    }

    @Override
    public ModelsByMetrics bestModels(InputModel inputModel) {
        ModelsByMetrics modelsByMetrics = new ModelsByMetrics();
        for (ModelAndEvaluator modelAndEvaluator : m_modelAndEvaluatorLister.list()) {
            SoftwareModel softwareModel = modelAndEvaluator.getSoftwareModel();
            HardwareModel hardwareModel = modelAndEvaluator.getHardwareModel();
            QoSMetricsEvaluator qoSMetricsEvaluator = modelAndEvaluator.getQoSMetricsEvaluator();
            SoftwareMetricsEvaluator softwareMetricsEvaluator = modelAndEvaluator.getSoftwareMetricsEvaluator();
            SoftwareMetrics softwareMetrics = softwareMetricsEvaluator.evaluate(softwareModel, inputModel);
            QoSMetrics metrics = qoSMetricsEvaluator.evaluate(softwareMetrics, hardwareModel);
            modelsByMetrics.compareAndUpdate(metrics, softwareModel);
        }
        return modelsByMetrics;
    }

}