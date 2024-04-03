package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;

@TargetApi(17)
public final class zzci {
    private static zzci zzb;
    String zza;

    private zzci() {
    }

    public static zzci zza() {
        if (zzb == null) {
            zzb = new zzci();
        }
        return zzb;
    }
}
