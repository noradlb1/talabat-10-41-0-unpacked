package com.newrelic.agent.android.hybrid;

import com.newrelic.agent.android.hybrid.rninterface.IStackTraceException;

public class StackTraceException implements IStackTraceException {
    private final String cause;

    /* renamed from: name  reason: collision with root package name */
    private final String f52782name;

    public StackTraceException(String str, String str2) {
        this.f52782name = str;
        this.cause = str2;
    }

    public String getCause() {
        return this.cause;
    }

    public String getExceptionName() {
        return this.f52782name;
    }
}
