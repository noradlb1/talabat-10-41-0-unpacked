package org.junit.jupiter.api;

import j$.util.function.Supplier;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.opentest4j.AssertionFailedError;

class AssertDoesNotThrow {
    private AssertDoesNotThrow() {
    }

    public static <T> T a(ThrowingSupplier<T> throwingSupplier) {
        return assertDoesNotThrow(throwingSupplier, (Object) null);
    }

    private static void assertDoesNotThrow(Executable executable, Object obj) {
        try {
            executable.execute();
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            throw createAssertionFailedError(obj, th2);
        }
    }

    public static <T> T b(ThrowingSupplier<T> throwingSupplier, String str) {
        return assertDoesNotThrow(throwingSupplier, (Object) str);
    }

    private static String buildSuffix(String str) {
        if (!StringUtils.isNotBlank(str)) {
            return "";
        }
        return ": " + str;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.function.Supplier<java.lang.String>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T c(org.junit.jupiter.api.function.ThrowingSupplier<T> r0, j$.util.function.Supplier<java.lang.String> r1) {
        /*
            java.lang.Object r0 = assertDoesNotThrow(r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertDoesNotThrow.c(org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier):java.lang.Object");
    }

    private static AssertionFailedError createAssertionFailedError(Object obj, Throwable th2) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
        return message.reason("Unexpected exception thrown: " + th2.getClass().getName() + buildSuffix(th2.getMessage())).cause(th2).build();
    }

    public static void d(Executable executable) {
        assertDoesNotThrow(executable, (Object) null);
    }

    public static void e(Executable executable, String str) {
        assertDoesNotThrow(executable, (Object) str);
    }

    public static void f(Executable executable, Supplier<String> supplier) {
        assertDoesNotThrow(executable, (Object) supplier);
    }

    private static <T> T assertDoesNotThrow(ThrowingSupplier<T> throwingSupplier, Object obj) {
        try {
            return throwingSupplier.get();
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            throw createAssertionFailedError(obj, th2);
        }
    }
}
