package org.junit.platform.commons.util;

import org.apiguardian.api.API;

@API(since = "1.7", status = API.Status.INTERNAL)
public final class UnrecoverableExceptions {
    private UnrecoverableExceptions() {
    }

    public static void rethrowIfUnrecoverable(Throwable th2) {
        if (th2 instanceof OutOfMemoryError) {
            ExceptionUtils.throwAsUncheckedException(th2);
        }
    }
}
