package com.google.zxing;

public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE = new StackTraceElement[0];
    protected static final boolean isStackTrace;

    static {
        boolean z11;
        if (System.getProperty("surefire.test.class.path") != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        isStackTrace = z11;
    }

    public ReaderException() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public ReaderException(Throwable th2) {
        super(th2);
    }
}
