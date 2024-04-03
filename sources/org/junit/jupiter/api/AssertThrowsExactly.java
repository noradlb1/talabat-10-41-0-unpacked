package org.junit.jupiter.api;

import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.util.UnrecoverableExceptions;

class AssertThrowsExactly {
    private AssertThrowsExactly() {
    }

    public static <T extends Throwable> T a(Class<T> cls, Executable executable) {
        return assertThrowsExactly(cls, executable, (Object) null);
    }

    private static <T extends Throwable> T assertThrowsExactly(Class<T> cls, Executable executable, Object obj) {
        try {
            executable.execute();
            throw AssertionFailureBuilder.assertionFailure().message(obj).reason(String.format("Expected %s to be thrown, but nothing was thrown.", new Object[]{AssertionUtils.m(cls)})).build();
        } catch (Throwable th2) {
            if (cls.equals(th2.getClass())) {
                return th2;
            }
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            throw AssertionFailureBuilder.assertionFailure().message(obj).expected(cls).actual(th2.getClass()).reason("Unexpected exception type thrown").cause(th2).build();
        }
    }

    public static <T extends Throwable> T b(Class<T> cls, Executable executable, String str) {
        return assertThrowsExactly(cls, executable, str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier<java.lang.String>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Throwable> T c(java.lang.Class<T> r0, org.junit.jupiter.api.function.Executable r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Throwable r0 = assertThrowsExactly(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertThrowsExactly.c(java.lang.Class, org.junit.jupiter.api.function.Executable, j$.util.function.Supplier):java.lang.Throwable");
    }
}
