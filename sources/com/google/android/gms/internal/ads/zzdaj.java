package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdaj implements zzgpr<zzdae> {
    private final zzgqe<zzdau> zza;
    private final zzgqe<zzbpz> zzb;
    private final zzgqe<Runnable> zzc;
    private final zzgqe<Executor> zzd;

    public zzdaj(zzgqe<zzdau> zzgqe, zzgqe<zzbpz> zzgqe2, zzgqe<Runnable> zzgqe3, zzgqe<Executor> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdae(((zzdcq) this.zza).zzb(), ((zzdai) this.zzb).zza(), ((zzdah) this.zzc).zza(), this.zzd.zzb());
    }
}
