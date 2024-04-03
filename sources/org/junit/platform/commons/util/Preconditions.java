package org.junit.platform.commons.util;

import j$.lang.Iterable;
import j$.util.DesugarArrays;
import j$.util.function.Supplier;
import java.util.Collection;
import l30.l0;
import l30.m0;
import l30.n0;
import l30.o0;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class Preconditions {
    private Preconditions() {
    }

    public static void condition(boolean z11, String str) throws PreconditionViolationException {
        if (!z11) {
            throw new PreconditionViolationException(str);
        }
    }

    public static <T> T[] containsNoNullElements(T[] tArr, String str) throws PreconditionViolationException {
        if (tArr != null) {
            DesugarArrays.stream(tArr).forEach(new l0(str));
        }
        return tArr;
    }

    public static String notBlank(String str, String str2) throws PreconditionViolationException {
        condition(StringUtils.isNotBlank(str), str2);
        return str;
    }

    @API(since = "1.9", status = API.Status.EXPERIMENTAL)
    public static int[] notEmpty(int[] iArr, String str) throws PreconditionViolationException {
        condition(iArr != null && iArr.length > 0, str);
        return iArr;
    }

    public static <T> T notNull(T t11, String str) throws PreconditionViolationException {
        condition(t11 != null, str);
        return t11;
    }

    public static void condition(boolean z11, Supplier<String> supplier) throws PreconditionViolationException {
        if (!z11) {
            throw new PreconditionViolationException(supplier.get());
        }
    }

    public static <T> T[] containsNoNullElements(T[] tArr, Supplier<String> supplier) throws PreconditionViolationException {
        if (tArr != null) {
            DesugarArrays.stream(tArr).forEach(new m0(supplier));
        }
        return tArr;
    }

    public static String notBlank(String str, Supplier<String> supplier) throws PreconditionViolationException {
        condition(StringUtils.isNotBlank(str), supplier);
        return str;
    }

    public static <T> T[] notEmpty(T[] tArr, String str) throws PreconditionViolationException {
        condition(tArr != null && tArr.length > 0, str);
        return tArr;
    }

    public static <T> T notNull(T t11, Supplier<String> supplier) throws PreconditionViolationException {
        condition(t11 != null, supplier);
        return t11;
    }

    public static <T extends Collection<?>> T containsNoNullElements(T t11, String str) throws PreconditionViolationException {
        if (t11 != null) {
            Iterable.EL.forEach(t11, new o0(str));
        }
        return t11;
    }

    public static <T> T[] notEmpty(T[] tArr, Supplier<String> supplier) throws PreconditionViolationException {
        condition(tArr != null && tArr.length > 0, supplier);
        return tArr;
    }

    public static <T extends Collection<?>> T containsNoNullElements(T t11, Supplier<String> supplier) throws PreconditionViolationException {
        if (t11 != null) {
            Iterable.EL.forEach(t11, new n0(supplier));
        }
        return t11;
    }

    public static <T extends Collection<?>> T notEmpty(T t11, String str) throws PreconditionViolationException {
        condition(t11 != null && !t11.isEmpty(), str);
        return t11;
    }

    public static <T extends Collection<?>> T notEmpty(T t11, Supplier<String> supplier) throws PreconditionViolationException {
        condition(t11 != null && !t11.isEmpty(), supplier);
        return t11;
    }
}
