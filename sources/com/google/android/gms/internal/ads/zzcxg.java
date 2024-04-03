package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcxg implements zzgpr<zzcxf> {
    private final zzgqe<zzbwq> zza;
    private final zzgqe<zzcxb> zzb;
    private final zzgqe<Executor> zzc;
    private final zzgqe<zzcxa> zzd;
    private final zzgqe<Clock> zze;

    public zzcxg(zzgqe<zzbwq> zzgqe, zzgqe<zzcxb> zzgqe2, zzgqe<Executor> zzgqe3, zzgqe<zzcxa> zzgqe4, zzgqe<Clock> zzgqe5) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxf(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb());
    }
}
