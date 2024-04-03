package org.mockito.internal.stubbing.answers;

import java.io.Serializable;

public class ThrowsException extends AbstractThrowsException implements Serializable {
    private static final long serialVersionUID = 1128820328555183980L;
    private final Throwable throwable;

    public ThrowsException(Throwable th2) {
        this.throwable = th2;
    }

    public Throwable a() {
        return this.throwable;
    }
}
