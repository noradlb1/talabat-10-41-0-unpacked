package org.junit.jupiter.api;

import j$.time.Duration;
import j$.util.function.Supplier;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.junit.platform.commons.util.ExceptionUtils;

class AssertTimeout {
    private AssertTimeout() {
    }

    private static <T> T assertTimeout(Duration duration, ThrowingSupplier<T> throwingSupplier, Object obj) {
        T t11;
        long millis = duration.toMillis();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            t11 = throwingSupplier.get();
        } catch (Throwable th2) {
            ExceptionUtils.throwAsUncheckedException(th2);
            t11 = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > millis) {
            AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
            message.reason("execution exceeded timeout of " + millis + " ms by " + (currentTimeMillis2 - millis) + " ms").buildAndThrow();
        }
        return t11;
    }

    public static <T> T c(Duration duration, ThrowingSupplier<T> throwingSupplier) {
        return assertTimeout(duration, throwingSupplier, (Object) null);
    }

    public static <T> T d(Duration duration, ThrowingSupplier<T> throwingSupplier, String str) {
        return assertTimeout(duration, throwingSupplier, str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier<java.lang.String>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T e(j$.time.Duration r0, org.junit.jupiter.api.function.ThrowingSupplier<T> r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Object r0 = assertTimeout(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertTimeout.e(j$.time.Duration, org.junit.jupiter.api.function.ThrowingSupplier, j$.util.function.Supplier):java.lang.Object");
    }

    public static void f(Duration duration, Executable executable) {
        g(duration, executable, (String) null);
    }

    public static void g(Duration duration, Executable executable, String str) {
        d(duration, new f(executable), str);
    }

    public static void h(Duration duration, Executable executable, Supplier<String> supplier) {
        e(duration, new g(executable), supplier);
    }
}
