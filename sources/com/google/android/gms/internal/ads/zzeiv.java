package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzaw;
import java.util.concurrent.Executor;

public final class zzeiv implements zzgpr<zzeiu> {
    private final zzgqe<zzczt> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<Executor> zzc;
    private final zzgqe<zzdwj> zzd;
    private final zzgqe<zzfef> zze;
    private final zzgqe<zzfpv<zzfdn, zzaw>> zzf;

    public zzeiv(zzgqe<zzczt> zzgqe, zzgqe<Context> zzgqe2, zzgqe<Executor> zzgqe3, zzgqe<zzdwj> zzgqe4, zzgqe<zzfef> zzgqe5, zzgqe<zzfpv<zzfdn, zzaw>> zzgqe6) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
    }

    /* renamed from: zza */
    public final zzeiu zzb() {
        return new zzeiu(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), ((zzdei) this.zze).zza(), this.zzf.zzb());
    }
}
