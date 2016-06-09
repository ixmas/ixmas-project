package org.ixmas.ixmatrixmult.improver;

import java.util.Objects;

public class Metrics {

    private int m_operationNumber = 0;
    private int m_valueCopy = 0;
    private int m_memorySize = 0;

    public void increaseOperationNumber(int operationNumber) {
        m_operationNumber += operationNumber;
    }

    public void increaseValueCopy(int valueCopy) {
        m_valueCopy += valueCopy;
    }

    public void increaseMemorySize(int memorySize) {
        m_memorySize += memorySize;
    }

    public int getOperationNumber() {
        return m_operationNumber;
    }

    public int getValueCopy() {
        return m_valueCopy;
    }

    public int getMemorySize() {
        return m_memorySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metrics metrics = (Metrics) o;
        return m_operationNumber == metrics.m_operationNumber &&
                m_valueCopy == metrics.m_valueCopy &&
                m_memorySize == metrics.m_memorySize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_operationNumber, m_valueCopy, m_memorySize);
    }
}
