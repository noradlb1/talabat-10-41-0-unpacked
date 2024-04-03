package org.junit.jupiter.api;

import j$.util.function.Supplier;

class AssertNull {
    private AssertNull() {
    }

    public static void a(Object obj) {
        b(obj, (String) null);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            failNotNull(obj, str);
        }
    }

    public static void c(Object obj, Supplier<String> supplier) {
        if (obj != null) {
            failNotNull(obj, supplier);
        }
    }

    private static void failNotNull(Object obj, Object obj2) {
        AssertionFailureBuilder.assertionFailure().message(obj2).expected((Object) null).actual(obj).buildAndThrow();
    }
}
