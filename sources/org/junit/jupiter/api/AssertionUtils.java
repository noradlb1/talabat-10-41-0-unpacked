package org.junit.jupiter.api;

import j$.util.Collection;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.util.Deque;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.opentest4j.AssertionFailedError;
import x20.e;

class AssertionUtils {
    private AssertionUtils() {
    }

    public static void a(double d11) {
        if (Double.isNaN(d11) || d11 < 0.0d) {
            failIllegalDelta(String.valueOf(d11));
        }
    }

    public static void b(float f11) {
        if (Float.isNaN(f11) || ((double) f11) < 0.0d) {
            failIllegalDelta(String.valueOf(f11));
        }
    }

    public static boolean c(double d11, double d12) {
        return Double.doubleToLongBits(d11) == Double.doubleToLongBits(d12);
    }

    public static boolean d(double d11, double d12, double d13) {
        a(d13);
        if (c(d11, d12) || Math.abs(d11 - d12) <= d13) {
            return true;
        }
        return false;
    }

    public static void e() {
        throw new AssertionFailedError();
    }

    public static void f(String str) {
        throw new AssertionFailedError(str);
    }

    private static void failIllegalDelta(String str) {
        f("positive delta expected but was: <" + str + ">");
    }

    public static void g(String str, Throwable th2) {
        throw new AssertionFailedError(str, th2);
    }

    public static void h(Throwable th2) {
        throw new AssertionFailedError((String) null, th2);
    }

    public static void i(Supplier<String> supplier) {
        throw new AssertionFailedError(n(supplier));
    }

    public static boolean j(float f11, float f12) {
        return Float.floatToIntBits(f11) == Float.floatToIntBits(f12);
    }

    public static boolean k(float f11, float f12, float f13) {
        b(f13);
        if (j(f11, f12) || Math.abs(f11 - f12) <= f13) {
            return true;
        }
        return false;
    }

    public static String l(Deque<Integer> deque) {
        if (deque == null || deque.isEmpty()) {
            return "";
        }
        return " at index " + ((String) Collection.EL.stream(deque).map(new e()).collect(Collectors.joining("][", "[", "]")));
    }

    public static String m(Class<?> cls) {
        try {
            String canonicalName = cls.getCanonicalName();
            if (canonicalName != null) {
                return canonicalName;
            }
            return cls.getName();
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            return cls.getName();
        }
    }

    public static String n(Supplier<String> supplier) {
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public static boolean o(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
