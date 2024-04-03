package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcxh implements zzgpr<zzcxa> {
    private final zzgqe<zzaxw> zza;
    private final zzgqe<zzbwq> zzb;
    private final zzgqe<Executor> zzc;

    public zzcxh(zzgqe<zzaxw> zzgqe, zzgqe<zzbwq> zzgqe2, zzgqe<Executor> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zza2 = zzfgr.zza();
        zzgpz.zzb(zza2);
        return new zzcxa(this.zza.zzb().zzc(), this.zzb.zzb(), zza2);
    }
}
