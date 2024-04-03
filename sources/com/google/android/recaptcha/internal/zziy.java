package com.google.android.recaptcha.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zziy {
    public static final /* synthetic */ int zza = 0;
    private static final zziy zzb = new zziy();
    private final zzjd zzc = new zzih();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    private zziy() {
    }

    public static zziy zza() {
        return zzb;
    }

    public final zzjc zzb(Class cls) {
        zzhn.zzc(cls, "messageType");
        zzjc zzjc = (zzjc) this.zzd.get(cls);
        if (zzjc == null) {
            zzjc = this.zzc.zza(cls);
            zzhn.zzc(cls, "messageType");
            zzhn.zzc(zzjc, "schema");
            zzjc zzjc2 = (zzjc) this.zzd.putIfAbsent(cls, zzjc);
            if (zzjc2 == null) {
                return zzjc;
            }
            return zzjc2;
        }
        return zzjc;
    }
}
