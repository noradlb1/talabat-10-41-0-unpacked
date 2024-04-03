package org.junit.jupiter.api;

import j$.util.function.Supplier;

class AssertNotSame {
    private AssertNotSame() {
    }

    public static void a(Object obj, Object obj2) {
        b(obj, obj2, (String) null);
    }

    public static void b(Object obj, Object obj2, String str) {
        if (obj == obj2) {
            failSame(obj2, str);
        }
    }

    public static void c(Object obj, Object obj2, Supplier<String> supplier) {
        if (obj == obj2) {
            failSame(obj2, supplier);
        }
    }

    private static void failSame(Object obj, Object obj2) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj2);
        message.reason("expected: not same but was: <" + obj + ">").buildAndThrow();
    }
}
