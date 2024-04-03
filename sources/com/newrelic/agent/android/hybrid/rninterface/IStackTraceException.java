package com.newrelic.agent.android.hybrid.rninterface;

public interface IStackTraceException {
    String getCause();

    String getExceptionName();
}
