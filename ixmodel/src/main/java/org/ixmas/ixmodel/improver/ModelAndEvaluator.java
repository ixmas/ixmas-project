package org.ixmas.ixmodel.improver;

public class ModelAndEvaluator {

    private final HardwareModel m_hardwareModel;
    private SoftwareModel m_softwareModel;
    private QoSMetricsEvaluator m_qoSMetricsEvaluator;
    private SoftwareMetricsEvaluator m_softwareMetricsEvaluator;

    public ModelAndEvaluator(SoftwareModel softwareModel, HardwareModel hardwareModel, QoSMetricsEvaluator qoSMetricsEvaluator, SoftwareMetricsEvaluator softwareMetricsEvaluator) {
        m_softwareModel = softwareModel;
        m_hardwareModel = hardwareModel;
        m_qoSMetricsEvaluator = qoSMetricsEvaluator;
        m_softwareMetricsEvaluator = softwareMetricsEvaluator;
    }

    public SoftwareModel getSoftwareModel() {
        return m_softwareModel;
    }

    public HardwareModel getHardwareModel() {
        return m_hardwareModel;
    }

    public QoSMetricsEvaluator getQoSMetricsEvaluator() {
        return m_qoSMetricsEvaluator;
    }

    public SoftwareMetricsEvaluator getSoftwareMetricsEvaluator() {
        return m_softwareMetricsEvaluator;
    }
}
