package com.newrelic.agent.android.hybrid.rninterface;

import java.util.Map;

public interface IStackTrace {
    String getBuildId();

    Map<String, Object> getCustomAttributes();

    String getStackId();

    IStackTraceException getStackTraceException();

    String getStackType();

    IStack[] getStacks();

    boolean isFatal();
}
