package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdds implements zzgpr<zzddr> {
    private final zzgqe<zzdfj> zza;
    private final zzgqe<zzfdn> zzb;
    private final zzgqe<ScheduledExecutorService> zzc;
    private final zzgqe<Executor> zzd;

    public zzdds(zzgqe<zzdfj> zzgqe, zzgqe<zzfdn> zzgqe2, zzgqe<ScheduledExecutorService> zzgqe3, zzgqe<Executor> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzddr(this.zza.zzb(), ((zzdbl) this.zzb).zza(), this.zzc.zzb(), zzfxb);
    }
}
