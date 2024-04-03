package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgb;

public final class zzemu<AdT, AdapterT, ListenerT extends zzdgb> implements zzgpr<zzemt<AdT, AdapterT, ListenerT>> {
    private final zzgqe<zzfie> zza;
    private final zzgqe<zzfxb> zzb;
    private final zzgqe<zzehv<AdapterT, ListenerT>> zzc;
    private final zzgqe<zzeib<AdT, AdapterT, ListenerT>> zzd;

    public zzemu(zzgqe<zzfie> zzgqe, zzgqe<zzfxb> zzgqe2, zzgqe<zzehv<AdapterT, ListenerT>> zzgqe3, zzgqe<zzeib<AdT, AdapterT, ListenerT>> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    /* renamed from: zza */
    public final zzemt<AdT, AdapterT, ListenerT> zzb() {
        return new zzemt<>(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}
