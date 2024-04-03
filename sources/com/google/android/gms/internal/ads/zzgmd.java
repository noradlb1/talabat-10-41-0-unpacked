package com.google.android.gms.internal.ads;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzgmd {
    private static final zzgmd zza = new zzgmd();
    private final zzgmp zzb = new zzgln();
    private final ConcurrentMap<Class<?>, zzgmo<?>> zzc = new ConcurrentHashMap();

    private zzgmd() {
    }

    public static zzgmd zza() {
        return zza;
    }

    public final <T> zzgmo<T> zzb(Class<T> cls) {
        zzgkv.zzf(cls, "messageType");
        zzgmo<T> zzgmo = this.zzc.get(cls);
        if (zzgmo == null) {
            zzgmo = this.zzb.zza(cls);
            zzgkv.zzf(cls, "messageType");
            zzgkv.zzf(zzgmo, "schema");
            zzgmo<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzgmo);
            if (putIfAbsent == null) {
                return zzgmo;
            }
            return putIfAbsent;
        }
        return zzgmo;
    }
}
