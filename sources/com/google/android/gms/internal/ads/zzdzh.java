package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdzh implements zzgpr<zzdze> {
    private final zzgqe<Executor> zza;
    private final zzgqe<zzcje> zzb;
    private final zzgqe<zzfix> zzc;
    private final zzgqe<zzfiz> zzd;

    public zzdzh(zzgqe<Executor> zzgqe, zzgqe<zzcje> zzgqe2, zzgqe<zzfix> zzgqe3, zzgqe<zzfiz> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdze(zzfxb, this.zzb.zzb(), ((zzfiy) this.zzc).zzb(), new zzfiz());
    }
}
