package org.junit.jupiter.api;

import j$.util.function.BooleanSupplier;
import j$.util.function.Supplier;
import org.apiguardian.api.API;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.TestAbortedException;

@API(since = "5.0", status = API.Status.STABLE)
public class Assumptions {
    @API(since = "5.9", status = API.Status.STABLE)
    public static <V> V abort() {
        throw new TestAbortedException();
    }

    public static void assumeFalse(boolean z11) throws TestAbortedException {
        assumeFalse(z11, "assumption is not false");
    }

    public static void assumeTrue(boolean z11) throws TestAbortedException {
        assumeTrue(z11, "assumption is not true");
    }

    public static void assumingThat(BooleanSupplier booleanSupplier, Executable executable) {
        assumingThat(booleanSupplier.getAsBoolean(), executable);
    }

    private static void throwAssumptionFailed(String str) {
        String str2;
        if (StringUtils.isNotBlank(str)) {
            str2 = "Assumption failed: " + str;
        } else {
            str2 = "Assumption failed";
        }
        throw new TestAbortedException(str2);
    }

    @API(since = "5.9", status = API.Status.STABLE)
    public static <V> V abort(String str) {
        throw new TestAbortedException(str);
    }

    public static void assumeFalse(BooleanSupplier booleanSupplier) throws TestAbortedException {
        assumeFalse(booleanSupplier.getAsBoolean(), "assumption is not false");
    }

    public static void assumeTrue(BooleanSupplier booleanSupplier) throws TestAbortedException {
        assumeTrue(booleanSupplier.getAsBoolean(), "assumption is not true");
    }

    public static void assumingThat(boolean z11, Executable executable) {
        if (z11) {
            try {
                executable.execute();
            } catch (Throwable th2) {
                ExceptionUtils.throwAsUncheckedException(th2);
            }
        }
    }

    @API(since = "5.9", status = API.Status.STABLE)
    public static <V> V abort(Supplier<String> supplier) {
        throw new TestAbortedException(supplier.get());
    }

    public static void assumeFalse(BooleanSupplier booleanSupplier, String str) throws TestAbortedException {
        assumeFalse(booleanSupplier.getAsBoolean(), str);
    }

    public static void assumeTrue(BooleanSupplier booleanSupplier, String str) throws TestAbortedException {
        assumeTrue(booleanSupplier.getAsBoolean(), str);
    }

    public static void assumeFalse(boolean z11, Supplier<String> supplier) throws TestAbortedException {
        if (z11) {
            throwAssumptionFailed(supplier.get());
        }
    }

    public static void assumeTrue(boolean z11, Supplier<String> supplier) throws TestAbortedException {
        if (!z11) {
            throwAssumptionFailed(supplier.get());
        }
    }

    public static void assumeFalse(boolean z11, String str) throws TestAbortedException {
        if (z11) {
            throwAssumptionFailed(str);
        }
    }

    public static void assumeTrue(boolean z11, String str) throws TestAbortedException {
        if (!z11) {
            throwAssumptionFailed(str);
        }
    }

    public static void assumeFalse(BooleanSupplier booleanSupplier, Supplier<String> supplier) throws TestAbortedException {
        assumeFalse(booleanSupplier.getAsBoolean(), supplier);
    }

    public static void assumeTrue(BooleanSupplier booleanSupplier, Supplier<String> supplier) throws TestAbortedException {
        assumeTrue(booleanSupplier.getAsBoolean(), supplier);
    }
}
