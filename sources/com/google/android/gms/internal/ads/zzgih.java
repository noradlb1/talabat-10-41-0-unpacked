package com.google.android.gms.internal.ads;

public final class zzgih {
    public static int zza() {
        try {
            return Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt((Object) null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return -1;
        }
    }

    public static boolean zzb() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }
}
