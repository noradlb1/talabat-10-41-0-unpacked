package com.google.android.gms.internal.ads;

import java.util.HashSet;

public final class zzt {
    private static final HashSet<String> zza = new HashSet<>();
    private static final String zzb = "goog.exo.core";

    public static synchronized String zza() {
        String str;
        synchronized (zzt.class) {
            str = zzb;
        }
        return str;
    }
}
