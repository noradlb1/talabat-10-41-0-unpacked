package com.google.android.gms.internal.ads;

public final class zzgpz {
    public static <T> T zza(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static <T> T zzb(T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static <T> void zzc(T t11, Class<T> cls) {
        if (t11 == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
