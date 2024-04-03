package com.google.android.gms.internal.gtm;

final class zzpp {
    private static final Class<?> zzavt = zzcx("libcore.io.Memory");
    private static final boolean zzavu;

    static {
        boolean z11;
        if (zzcx("org.robolectric.Robolectric") != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzavu = z11;
    }

    private static <T> Class<T> zzcx(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzna() {
        return zzavt != null && !zzavu;
    }

    public static Class<?> zznb() {
        return zzavt;
    }
}
