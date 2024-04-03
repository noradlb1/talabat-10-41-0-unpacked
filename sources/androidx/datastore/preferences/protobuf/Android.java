package androidx.datastore.preferences.protobuf;

final class Android {
    private static final boolean IS_ROBOLECTRIC;
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    static {
        boolean z11;
        if (getClassForName("org.robolectric.Robolectric") != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        IS_ROBOLECTRIC = z11;
    }

    public static Class<?> a() {
        return MEMORY_CLASS;
    }

    public static boolean b() {
        return MEMORY_CLASS != null && !IS_ROBOLECTRIC;
    }

    private static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
