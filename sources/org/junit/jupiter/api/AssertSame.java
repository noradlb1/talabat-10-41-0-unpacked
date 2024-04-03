package org.junit.jupiter.api;

import j$.util.function.Supplier;

class AssertSame {
    private AssertSame() {
    }

    public static void a(Object obj, Object obj2) {
        b(obj, obj2, (String) null);
    }

    public static void b(Object obj, Object obj2, String str) {
        if (obj != obj2) {
            failNotSame(obj, obj2, str);
        }
    }

    public static void c(Object obj, Object obj2, Supplier<String> supplier) {
        if (obj != obj2) {
            failNotSame(obj, obj2, supplier);
        }
    }

    private static void failNotSame(Object obj, Object obj2, Object obj3) {
        AssertionFailureBuilder.assertionFailure().message(obj3).expected(obj).actual(obj2).buildAndThrow();
    }
}
