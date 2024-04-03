package com.google.android.gms.internal.vision;

final class zzfa {
    private static final Class<?> zzrm = zzv("libcore.io.Memory");
    private static final boolean zzrn;

    static {
        boolean z11;
        if (zzv("org.robolectric.Robolectric") != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzrn = z11;
    }

    public static boolean zzdr() {
        return zzrm != null && !zzrn;
    }

    public static Class<?> zzds() {
        return zzrm;
    }

    private static <T> Class<T> zzv(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
