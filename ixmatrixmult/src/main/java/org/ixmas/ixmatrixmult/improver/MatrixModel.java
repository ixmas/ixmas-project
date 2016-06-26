package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.InputModel;

import static com.google.common.base.Preconditions.checkArgument;

public class MatrixModel implements InputModel {

    private final int m_lineNumber;
    private final int m_columnNumber;

    public MatrixModel(int lineNumber, int columnNumber) {
        checkArgument(lineNumber > 0, "Wrong line number: lineNumber=%s should be greater than 0", lineNumber);
        checkArgument(columnNumber > 0, "Wrong column number: columnNumber=%s should be greater than 0", columnNumber);
        m_lineNumber = lineNumber;
        m_columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return m_lineNumber;
    }

    public int getColumnNumber() {
        return m_columnNumber;
    }
}
