package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzebc implements zzgpr<zzebb> {
    private final zzgqe<Executor> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<WeakReference<Context>> zzc;
    private final zzgqe<Executor> zzd;
    private final zzgqe<zzdww> zze;
    private final zzgqe<ScheduledExecutorService> zzf;
    private final zzgqe<zzdzi> zzg;
    private final zzgqe<zzcjf> zzh;
    private final zzgqe<zzdli> zzi;

    public zzebc(zzgqe<Executor> zzgqe, zzgqe<Context> zzgqe2, zzgqe<WeakReference<Context>> zzgqe3, zzgqe<Executor> zzgqe4, zzgqe<zzdww> zzgqe5, zzgqe<ScheduledExecutorService> zzgqe6, zzgqe<zzdzi> zzgqe7, zzgqe<zzcjf> zzgqe8, zzgqe<zzdli> zzgqe9) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
        this.zzi = zzgqe9;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcqr) this.zzb).zza();
        WeakReference<Context> zza3 = ((zzcqs) this.zzc).zza();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzebb(this.zza.zzb(), zza2, zza3, zzfxb, this.zze.zzb(), this.zzf.zzb(), this.zzg.zzb(), ((zzcrb) this.zzh).zza(), ((zzdlj) this.zzi).zzb());
    }
}
