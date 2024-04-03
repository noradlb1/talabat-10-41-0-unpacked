package com.google.android.libraries.places.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzadh {
    private static final zzadh zza = new zzadh();
    private final zzadl zzb = new zzacr();
    private final ConcurrentMap<Class<?>, zzadk<?>> zzc = new ConcurrentHashMap();

    private zzadh() {
    }

    public static zzadh zza() {
        return zza;
    }

    public final <T> zzadk<T> zzb(Class<T> cls) {
        zzaca.zzf(cls, "messageType");
        zzadk<T> zzadk = this.zzc.get(cls);
        if (zzadk == null) {
            zzadk = this.zzb.zza(cls);
            zzaca.zzf(cls, "messageType");
            zzaca.zzf(zzadk, "schema");
            zzadk<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzadk);
            if (putIfAbsent == null) {
                return zzadk;
            }
            return putIfAbsent;
        }
        return zzadk;
    }
}
