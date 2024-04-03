package com.newrelic.agent.android.hybrid.rninterface;

public interface IStackFrame {
    String getClassName();

    int getColumnNumber();

    String getFileName();

    int getLineNumber();

    String getMethodName();

    String getRawSourceLine();
}
