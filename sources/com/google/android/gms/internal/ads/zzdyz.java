package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
public final class zzdyz {
    /* access modifiers changed from: private */
    public final zzdze zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map<String, String> zzc;

    public zzdyz(zzdze zzdze, Executor executor) {
        this.zza = zzdze;
        this.zzc = zzdze.zza();
        this.zzb = executor;
    }

    public final zzdyy zza() {
        zzdyy zzdyy = new zzdyy(this);
        zzdyy unused = zzdyy.zzb.putAll(zzdyy.zza.zzc);
        return zzdyy;
    }
}
