package org.ixmas.ixmatrixmult.improver;

import org.ixmas.ixmodel.improver.InputModel;

import static com.google.common.base.Preconditions.checkArgument;

public class MatrixModel implements InputModel {

    private final int m_lineNumber;
    private final int m_columnNumber;

    public MatrixModel(int lineNumber, int columnNumber) {
        checkArgument(lineNumber > 0, "lineNumber > 0");
        checkArgument(columnNumber > 0, "columnNumber > 0");
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
