package com.google.android.gms.internal.consent_sdk;

public final class zzcu {
    public static <T> T zza(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T zza(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static <T> void zza(T t11, Class<T> cls) {
        if (t11 == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
