package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdtu implements zzgpr<zzdts> {
    private final zzgqe<Executor> zza;
    private final zzgqe<zzcxp> zzb;
    private final zzgqe<zzdly> zzc;

    public zzdtu(zzgqe<Executor> zzgqe, zzgqe<zzcxp> zzgqe2, zzgqe<zzdly> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdts(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
