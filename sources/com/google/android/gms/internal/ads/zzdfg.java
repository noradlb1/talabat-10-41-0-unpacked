package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdfg implements zzgpr<zzdfe> {
    private final zzgqe<zzdfd> zza;
    private final zzgqe<Set<zzdlw<zzdev>>> zzb;
    private final zzgqe<Executor> zzc;
    private final zzgqe<ScheduledExecutorService> zzd;

    public zzdfg(zzgqe<zzdfd> zzgqe, zzgqe<Set<zzdlw<zzdev>>> zzgqe2, zzgqe<Executor> zzgqe3, zzgqe<ScheduledExecutorService> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdfd zza2 = ((zzdff) this.zza).zzb();
        Set zzc2 = ((zzgqc) this.zzb).zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdfe(zza2, zzc2, zzfxb, this.zzd.zzb());
    }
}
