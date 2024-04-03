package org.mockito.internal.matchers;

import java.lang.reflect.Array;

public final class Equality {
    private Equality() {
    }

    public static boolean a(Object obj, Object obj2) {
        for (int i11 = 0; i11 < Array.getLength(obj); i11++) {
            if (!areEqual(Array.get(obj, i11), Array.get(obj2, i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (!d(obj)) {
            return obj.equals(obj2);
        }
        if (!d(obj2) || !c(obj, obj2)) {
            return false;
        }
        return true;
    }

    public static boolean b(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    public static boolean c(Object obj, Object obj2) {
        return b(obj, obj2) && a(obj, obj2);
    }

    public static boolean d(Object obj) {
        return obj.getClass().isArray();
    }
}
