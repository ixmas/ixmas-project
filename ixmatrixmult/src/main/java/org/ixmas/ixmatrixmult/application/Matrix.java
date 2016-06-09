package org.ixmas.ixmatrixmult.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class Matrix {

    private final int m_lineNumber;
    private final int m_columnNumber;
    private final List<List<Double>> m_lines;

    public Matrix(int lineNumber, int columnNumber) {
        checkArgument(lineNumber > 0, "lineNumber > 0");
        checkArgument(columnNumber > 0, "columnNumber > 0");
        m_lineNumber = lineNumber;
        m_columnNumber = columnNumber;
        m_lines = new ArrayList<>(lineNumber);
        for (int lineIdx = 0; lineIdx < lineNumber; lineIdx++) {
            ArrayList<Double> line = new ArrayList<>(columnNumber);
            m_lines.add(line);
            for (int columnIdx = 0; columnIdx < columnNumber; columnIdx++) {
                line.add(0.);
            }
        }
    }

    public void set(int lineIdx, int columnIdx, Double value) {
        checkArgument(lineIdx >= 0 && lineIdx < m_lineNumber, "lineIdx >= 0 && lineIdx < m_lineNumber");
        checkArgument(columnIdx >= 0 && columnIdx < m_columnNumber, "columnIdx >= 0 && columnIdx < m_columnNumber");
        m_lines.get(lineIdx).set(columnIdx, value);
    }

    public void setLine(int lineIdx, Double... values) {
        checkArgument(lineIdx >= 0 && lineIdx < m_lineNumber, "lineIdx >= 0 && lineIdx < m_lineNumber");
        checkArgument(values.length == m_columnNumber, "values.length == m_columnNumber");
        for (int columnIdx = 0; columnIdx < values.length; columnIdx++) {
            m_lines.get(lineIdx).set(columnIdx, values[columnIdx]);
        }
    }

    public void setValues(Double[]... lines) {
        checkArgument(lines.length == m_lineNumber, "lines.length == m_lineNumber");
        for (int lineIdx = 0; lineIdx < lines.length; lineIdx++) {
            Double[] line = lines[lineIdx];
            checkArgument(line.length == m_columnNumber);
            for (int columnIdx = 0; columnIdx < line.length; columnIdx++) {
                m_lines.get(lineIdx).set(columnIdx, line[columnIdx]);
            }
        }
    }

    public Double get(int lineIdx, int columnIdx) {
        checkArgument(lineIdx >= 0 && lineIdx < m_lineNumber, "lineIdx >= 0 && lineIdx < m_lineNumber");
        checkArgument(columnIdx >= 0 && columnIdx < m_columnNumber, "columnIdx >= 0 && columnIdx < m_columnNumber");
        return m_lines.get(lineIdx).get(columnIdx);
    }

    public int getLineNumber() {
        return m_lineNumber;
    }

    public int getColumnNumber() {
        return m_columnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return m_lineNumber == matrix.m_lineNumber &&
                m_columnNumber == matrix.m_columnNumber &&
                Objects.equals(m_lines, matrix.m_lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_lineNumber, m_columnNumber, m_lines);
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "m_lineNumber=" + m_lineNumber +
                ", m_columnNumber=" + m_columnNumber +
                ", m_lines=" + m_lines +
                '}';
    }
}
