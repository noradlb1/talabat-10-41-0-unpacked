package org.mockito.exceptions.base;

import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;

public class MockitoException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private StackTraceElement[] unfilteredStackTrace;

    public MockitoException(String str, Throwable th2) {
        super(str, th2);
        filterStackTrace();
    }

    private void filterStackTrace() {
        this.unfilteredStackTrace = getStackTrace();
        new ConditionalStackTraceFilter().filter(this);
    }

    public StackTraceElement[] getUnfilteredStackTrace() {
        return this.unfilteredStackTrace;
    }

    public MockitoException(String str) {
        super(str);
        filterStackTrace();
    }
}
