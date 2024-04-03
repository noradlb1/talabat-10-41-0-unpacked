package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdth implements zzgpr<zzdtg> {
    private final zzgqe<Executor> zza;
    private final zzgqe<zzdtb> zzb;

    public zzdth(zzgqe<Executor> zzgqe, zzgqe<zzdtb> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    /* renamed from: zza */
    public final zzdtg zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdtg(zzfxb, ((zzdtc) this.zzb).zzb());
    }
}
