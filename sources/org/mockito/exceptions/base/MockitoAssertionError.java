package org.mockito.exceptions.base;

import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;

public class MockitoAssertionError extends AssertionError {
    private static final long serialVersionUID = 1;
    private final StackTraceElement[] unfilteredStackTrace;

    public MockitoAssertionError(String str) {
        super(str);
        this.unfilteredStackTrace = getStackTrace();
        new ConditionalStackTraceFilter().filter(this);
    }

    public StackTraceElement[] getUnfilteredStackTrace() {
        return this.unfilteredStackTrace;
    }

    public MockitoAssertionError(MockitoAssertionError mockitoAssertionError, String str) {
        super(str + StringUtils.LF + mockitoAssertionError.getMessage());
        super.setStackTrace(mockitoAssertionError.getStackTrace());
        this.unfilteredStackTrace = mockitoAssertionError.getUnfilteredStackTrace();
    }

    public MockitoAssertionError(AssertionError assertionError, String str) {
        super(str + StringUtils.LF + assertionError.getMessage());
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        this.unfilteredStackTrace = stackTrace;
        super.setStackTrace(stackTrace);
    }
}
