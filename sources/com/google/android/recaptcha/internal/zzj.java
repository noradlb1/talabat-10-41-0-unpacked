package com.google.android.recaptcha.internal;

import j$.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public final class zzj {
    @NotNull
    public static final zzj zza = new zzj();
    @NotNull
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    private zzj() {
    }

    public static final void zza(int i11, long j11) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer valueOf = Integer.valueOf(i11);
        Object obj = concurrentHashMap.get(valueOf);
        if (obj == null) {
            obj = new zzi();
        }
        zzi zzi = (zzi) obj;
        zzi.zzg(zzi.zzb() + 1);
        zzi.zzf(zzi.zzd() + j11);
        zzi.zze(Math.max(j11, zzi.zzc()));
        concurrentHashMap.put(valueOf, zzi);
    }
}
