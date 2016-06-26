package org.ixmas.ixmatrixmult.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Arrays.asList;

public class Matrix {

    private final int m_lineNumber;
    private final int m_columnNumber;
    private final List<List<Double>> m_lines;

    public Matrix(int lineNumber, int columnNumber) {
        checkArgument(lineNumber > 0, "Wrong line number: lineNumber=%s should be greater than 0", lineNumber);
        checkArgument(columnNumber > 0, "Wrong column number: columnNumber=%s should be greater than 0", columnNumber);
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
        checkLineIdxColumnIdx(lineIdx, columnIdx);
        m_lines.get(lineIdx).set(columnIdx, value);
    }

    public void setLine(int lineIdx, Double... values) {
        setLine(lineIdx, asList(values));
    }

    public void setLine(int lineIdx, List<Double> values) {
        checkLineIdx(lineIdx);
        checkArgument(values.size() == m_columnNumber, "Wrong number of columns in lineIdx=%s: %s should equal to %s", lineIdx, values.size(), m_columnNumber);
        for (int columnIdx = 0; columnIdx < values.size(); columnIdx++) {
            m_lines.get(lineIdx).set(columnIdx, values.get(columnIdx));
        }
    }

    public void setValues(Double[]... lines) {
        checkArgument(lines.length == m_lineNumber, "Wrong number of lines: lines.length=%s should equal to lineNumber=%s", lines.length, m_lineNumber);
        for (int lineIdx = 0; lineIdx < lines.length; lineIdx++) {
            Double[] line = lines[lineIdx];
            checkArgument(line.length == m_columnNumber, "Wrong column number for line %s: %s should equal to %s", lineIdx, line.length, m_columnNumber);
            for (int columnIdx = 0; columnIdx < line.length; columnIdx++) {
                m_lines.get(lineIdx).set(columnIdx, line[columnIdx]);
            }
        }
    }

    public Double get(int lineIdx, int columnIdx) {
        checkLineIdxColumnIdx(lineIdx, columnIdx);
        return m_lines.get(lineIdx).get(columnIdx);
    }

    private void checkLineIdx(int lineIdx) {
        checkArgument(lineIdx >= 0, "Wrong lineIdx: lineIdx=%s should be positive or null", lineIdx);
        checkArgument(lineIdx < m_lineNumber, "Wrong lineIdx: lineIdx=%s should be less than lineNumber=%s", lineIdx, m_lineNumber);
    }

    private void checkColumnIdx(int columnIdx) {
        checkArgument(columnIdx >= 0, "Wrong columnIdx: columnIdx=%s should be positive or null", columnIdx);
        checkArgument(columnIdx < m_columnNumber, "Wrong columnIdx: columnIdx=%s should be less than columnNumber=%s", columnIdx, m_columnNumber);
    }

    private void checkLineIdxColumnIdx(int lineIdx, int columnIdx) {
        checkLineIdx(lineIdx);
        checkColumnIdx(columnIdx);
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

    public List<Double> getLine(int lineIdx) {
        return m_lines.get(lineIdx);
    }
}
