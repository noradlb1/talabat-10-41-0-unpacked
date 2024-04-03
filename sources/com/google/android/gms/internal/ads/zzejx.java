package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzejx implements zzgpr<zzejw> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzcjf> zzb;
    private final zzgqe<zzfef> zzc;
    private final zzgqe<Executor> zzd;
    private final zzgqe<zzdnt> zze;
    private final zzgqe<zzdwj> zzf;
    private final zzgqe<zzbrw> zzg;

    public zzejx(zzgqe<Context> zzgqe, zzgqe<zzcjf> zzgqe2, zzgqe<zzfef> zzgqe3, zzgqe<Executor> zzgqe4, zzgqe<zzdnt> zzgqe5, zzgqe<zzdwj> zzgqe6, zzgqe<zzbrw> zzgqe7) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzejw(this.zza.zzb(), ((zzcrb) this.zzb).zza(), ((zzdei) this.zzc).zza(), this.zzd.zzb(), this.zze.zzb(), this.zzf.zzb(), new zzbrw());
    }
}
