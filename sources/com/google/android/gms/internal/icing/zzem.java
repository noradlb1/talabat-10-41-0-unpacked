package com.google.android.gms.internal.icing;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzem {
    private static final zzem zza = new zzem();
    private final zzeq zzb = new zzdw();
    private final ConcurrentMap<Class<?>, zzep<?>> zzc = new ConcurrentHashMap();

    private zzem() {
    }

    public static zzem zza() {
        return zza;
    }

    public final <T> zzep<T> zzb(Class<T> cls) {
        zzdh.zzb(cls, "messageType");
        zzep<T> zzep = this.zzc.get(cls);
        if (zzep == null) {
            zzep = this.zzb.zza(cls);
            zzdh.zzb(cls, "messageType");
            zzdh.zzb(zzep, "schema");
            zzep<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzep);
            if (putIfAbsent == null) {
                return zzep;
            }
            return putIfAbsent;
        }
        return zzep;
    }
}
