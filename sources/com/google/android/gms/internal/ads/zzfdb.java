package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzfdb implements zzgpr<zzfda> {
    private final zzgqe<Context> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzcqm> zzc;
    private final zzgqe<zzfbc<zzdvs, zzdvn>> zzd;
    private final zzgqe<zzfcq> zze;
    private final zzgqe<zzfed> zzf;
    private final zzgqe<zzfea> zzg;

    public zzfdb(zzgqe<Context> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzcqm> zzgqe3, zzgqe<zzfbc<zzdvs, zzdvn>> zzgqe4, zzgqe<zzfcq> zzgqe5, zzgqe<zzfed> zzgqe6, zzgqe<zzfea> zzgqe7) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfda(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), ((zzfbh) this.zzd).zzb(), this.zze.zzb(), new zzfed(), this.zzg.zzb());
    }
}
