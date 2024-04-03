package org.junit.jupiter.api;

import j$.util.function.Supplier;

class AssertNotNull {
    private AssertNotNull() {
    }

    public static void a(Object obj) {
        b(obj, (String) null);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            failNull(str);
        }
    }

    public static void c(Object obj, Supplier<String> supplier) {
        if (obj == null) {
            failNull(supplier);
        }
    }

    private static void failNull(Object obj) {
        AssertionFailureBuilder.assertionFailure().message(obj).reason("expected: not <null>").buildAndThrow();
    }
}
