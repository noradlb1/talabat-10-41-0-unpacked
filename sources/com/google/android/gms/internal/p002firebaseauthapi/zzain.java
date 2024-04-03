package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzain  reason: invalid package */
final class zzain {
    private static final zzain zza = new zzain();
    private final zzais zzb = new zzahx();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzain() {
    }

    public static zzain zza() {
        return zza;
    }

    public final zzair zzb(Class cls) {
        zzahg.zzc(cls, "messageType");
        zzair zzair = (zzair) this.zzc.get(cls);
        if (zzair == null) {
            zzair = this.zzb.zza(cls);
            zzahg.zzc(cls, "messageType");
            zzair zzair2 = (zzair) this.zzc.putIfAbsent(cls, zzair);
            if (zzair2 == null) {
                return zzair;
            }
            return zzair2;
        }
        return zzair;
    }
}
