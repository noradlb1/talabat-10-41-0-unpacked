package org.junit.jupiter.api;

class AssertInstanceOf {
    private AssertInstanceOf() {
    }

    public static <T> T a(Class<T> cls, Object obj) {
        return assertInstanceOf(cls, obj, (Object) null);
    }

    private static <T> T assertInstanceOf(Class<T> cls, Object obj, Object obj2) {
        String str;
        Class<?> cls2;
        if (!cls.isInstance(obj)) {
            AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj2);
            if (obj == null) {
                str = "Unexpected null value";
            } else {
                str = "Unexpected type";
            }
            AssertionFailureBuilder expected = message.reason(str).expected(cls);
            if (obj == null) {
                cls2 = null;
            } else {
                cls2 = obj.getClass();
            }
            expected.actual(cls2).buildAndThrow();
        }
        return cls.cast(obj);
    }

    public static <T> T b(Class<T> cls, Object obj, String str) {
        return assertInstanceOf(cls, obj, str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [j$.util.function.Supplier<java.lang.String>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T c(java.lang.Class<T> r0, java.lang.Object r1, j$.util.function.Supplier<java.lang.String> r2) {
        /*
            java.lang.Object r0 = assertInstanceOf(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertInstanceOf.c(java.lang.Class, java.lang.Object, j$.util.function.Supplier):java.lang.Object");
    }
}
