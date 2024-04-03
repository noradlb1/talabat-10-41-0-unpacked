package com.google.android.gms.internal.places;

final class zzp {
    private static final Class<?> zzdw = zzh("libcore.io.Memory");
    private static final boolean zzdx;

    static {
        boolean z11;
        if (zzh("org.robolectric.Robolectric") != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdx = z11;
    }

    private static <T> Class<T> zzh(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzy() {
        return zzdw != null && !zzdx;
    }

    public static Class<?> zzz() {
        return zzdw;
    }
}
