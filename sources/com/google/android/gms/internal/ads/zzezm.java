package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzezm implements zzgpr<zzezl> {
    private final zzgqe<Context> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzcqm> zzc;
    private final zzgqe<zzfbc<zzcyk, zzcyp>> zzd;
    private final zzgqe<zzezj> zze;
    private final zzgqe<zzfed> zzf;

    public zzezm(zzgqe<Context> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzcqm> zzgqe3, zzgqe<zzfbc<zzcyk, zzcyp>> zzgqe4, zzgqe<zzezj> zzgqe5, zzgqe<zzfed> zzgqe6) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzezl(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), ((zzfbf) this.zzd).zzb(), this.zze.zzb(), new zzfed());
    }
}
