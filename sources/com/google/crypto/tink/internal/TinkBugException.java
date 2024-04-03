package com.google.crypto.tink.internal;

public final class TinkBugException extends RuntimeException {
    public TinkBugException(String str) {
        super(str);
    }

    public TinkBugException(String str, Throwable th2) {
        super(str, th2);
    }

    public TinkBugException(Throwable th2) {
        super(th2);
    }
}
