package org.junit.internal;

public final class Throwables {
    private Throwables() {
    }

    private static <T extends Throwable> void rethrow(Throwable th2) throws Throwable {
        throw th2;
    }

    public static Exception rethrowAsException(Throwable th2) throws Exception {
        rethrow(th2);
        return null;
    }
}
