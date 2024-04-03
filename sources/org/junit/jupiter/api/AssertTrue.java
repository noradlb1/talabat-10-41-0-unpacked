package org.junit.jupiter.api;

import j$.util.function.BooleanSupplier;
import j$.util.function.Supplier;

class AssertTrue {
    private AssertTrue() {
    }

    public static void a(BooleanSupplier booleanSupplier) {
        e(booleanSupplier.getAsBoolean(), (String) null);
    }

    public static void b(BooleanSupplier booleanSupplier, String str) {
        e(booleanSupplier.getAsBoolean(), str);
    }

    public static void c(BooleanSupplier booleanSupplier, Supplier<String> supplier) {
        f(booleanSupplier.getAsBoolean(), supplier);
    }

    public static void d(boolean z11) {
        e(z11, (String) null);
    }

    public static void e(boolean z11, String str) {
        if (!z11) {
            failNotTrue(str);
        }
    }

    public static void f(boolean z11, Supplier<String> supplier) {
        if (!z11) {
            failNotTrue(supplier);
        }
    }

    private static void failNotTrue(Object obj) {
        AssertionFailureBuilder.assertionFailure().message(obj).expected(Boolean.TRUE).actual(Boolean.FALSE).buildAndThrow();
    }
}
