package org.mockito.internal.util;

public final class Checks {
    private Checks() {
    }

    public static <T extends Iterable<?>> T checkItemsNotNull(T t11, String str) {
        checkNotNull(t11, str);
        for (Object next : t11) {
            checkNotNull(next, "item in " + str);
        }
        return t11;
    }

    public static <T> T checkNotNull(T t11, String str) {
        return checkNotNull(t11, str, (String) null);
    }

    public static <T> T checkNotNull(T t11, String str, String str2) {
        if (t11 != null) {
            return t11;
        }
        String str3 = str + " should not be null";
        if (str2 != null) {
            str3 = str3 + ". " + str2;
        }
        throw new IllegalArgumentException(str3);
    }
}
