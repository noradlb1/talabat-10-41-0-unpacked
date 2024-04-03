package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
public final class zzdze extends zzdzg {
    private final zzfix zzf;

    public zzdze(Executor executor, zzcje zzcje, zzfix zzfix, zzfiz zzfiz) {
        super(executor, zzcje, zzfiz);
        this.zzf = zzfix;
        zzfix.zza(this.zzb);
    }

    public final Map<String, String> zza() {
        return new HashMap(this.zzb);
    }
}
