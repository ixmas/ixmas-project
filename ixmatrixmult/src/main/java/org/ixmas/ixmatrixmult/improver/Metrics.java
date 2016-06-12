package org.ixmas.ixmatrixmult.improver;

import java.util.Objects;

public class Metrics {

    private int m_operationNumber = 0;
    private int m_operationNumberPerAuxiliary = 0;
    private int m_valueCopy = 0;
    private int m_valueCopyPerAuxiliary = 0;
    private int m_memorySize = 0;
    private int m_memorySizePerAuxiliary = 0;

    public int getOperationNumber() {
        return m_operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        m_operationNumber = operationNumber;
    }

    public int getOperationNumberPerAuxiliary() {
        return m_operationNumberPerAuxiliary;
    }

    public void setOperationNumberPerAuxiliary(int operationNumberPerAuxiliary) {
        m_operationNumberPerAuxiliary = operationNumberPerAuxiliary;
    }

    public int getValueCopy() {
        return m_valueCopy;
    }

    public void setValueCopy(int valueCopy) {
        m_valueCopy = valueCopy;
    }

    public int getValueCopyPerAuxiliary() {
        return m_valueCopyPerAuxiliary;
    }

    public void setValueCopyPerAuxiliary(int valueCopyPerAuxiliary) {
        m_valueCopyPerAuxiliary = valueCopyPerAuxiliary;
    }

    public int getMemorySize() {
        return m_memorySize;
    }

    public void setMemorySize(int memorySize) {
        m_memorySize = memorySize;
    }

    public int getMemorySizePerAuxiliary() {
        return m_memorySizePerAuxiliary;
    }

    public void setMemorySizePerAuxiliary(int memorySizePerAuxiliary) {
        m_memorySizePerAuxiliary = memorySizePerAuxiliary;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "m_operationNumber=" + m_operationNumber +
                ", m_operationNumberPerAuxiliary=" + m_operationNumberPerAuxiliary +
                ", m_valueCopy=" + m_valueCopy +
                ", m_valueCopyPerAuxiliary=" + m_valueCopyPerAuxiliary +
                ", m_memorySize=" + m_memorySize +
                ", m_memorySizePerAuxiliary=" + m_memorySizePerAuxiliary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metrics metrics = (Metrics) o;
        return m_operationNumber == metrics.m_operationNumber &&
                m_operationNumberPerAuxiliary == metrics.m_operationNumberPerAuxiliary &&
                m_valueCopy == metrics.m_valueCopy &&
                m_valueCopyPerAuxiliary == metrics.m_valueCopyPerAuxiliary &&
                m_memorySize == metrics.m_memorySize &&
                m_memorySizePerAuxiliary == metrics.m_memorySizePerAuxiliary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_operationNumber, m_operationNumberPerAuxiliary, m_valueCopy, m_valueCopyPerAuxiliary, m_memorySize, m_memorySizePerAuxiliary);
    }
}
