package com.google.android.gms.internal.gtm;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzsw {
    private static final zzsw zzbdr = new zzsw();
    private final zzta zzbds = new zzrz();
    private final ConcurrentMap<Class<?>, zzsz<?>> zzbdt = new ConcurrentHashMap();

    private zzsw() {
    }

    public static zzsw zzqs() {
        return zzbdr;
    }

    public final <T> zzsz<T> zzaf(T t11) {
        return zzi(t11.getClass());
    }

    public final <T> zzsz<T> zzi(Class<T> cls) {
        zzre.zza(cls, "messageType");
        zzsz<T> zzsz = this.zzbdt.get(cls);
        if (zzsz != null) {
            return zzsz;
        }
        zzsz<T> zzh = this.zzbds.zzh(cls);
        zzre.zza(cls, "messageType");
        zzre.zza(zzh, "schema");
        zzsz<T> putIfAbsent = this.zzbdt.putIfAbsent(cls, zzh);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return zzh;
    }
}
