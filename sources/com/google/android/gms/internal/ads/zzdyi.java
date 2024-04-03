package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzdyi implements zzfif {
    private final Map<zzfhy, zzdyh> zza;
    private final zzbay zzb;

    public zzdyi(zzbay zzbay, Map<zzfhy, zzdyh> map) {
        this.zza = map;
        this.zzb = zzbay;
    }

    public final void zzb(zzfhy zzfhy, String str, Throwable th2) {
        if (this.zza.containsKey(zzfhy)) {
            this.zzb.zzc(this.zza.get(zzfhy).zzc);
        }
    }

    public final void zzbN(zzfhy zzfhy, String str) {
    }

    public final void zzbO(zzfhy zzfhy, String str) {
        if (this.zza.containsKey(zzfhy)) {
            this.zzb.zzc(this.zza.get(zzfhy).zzb);
        }
    }

    public final void zzc(zzfhy zzfhy, String str) {
        if (this.zza.containsKey(zzfhy)) {
            this.zzb.zzc(this.zza.get(zzfhy).zza);
        }
    }
}
