package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzewt implements zzgpr<zzewr> {
    private final zzgqe<zzcic> zza;
    private final zzgqe<Integer> zzb;
    private final zzgqe<Context> zzc;
    private final zzgqe<zzcik> zzd;
    private final zzgqe<ScheduledExecutorService> zze;
    private final zzgqe<Executor> zzf;
    private final zzgqe<String> zzg;

    public zzewt(zzgqe<zzcic> zzgqe, zzgqe<Integer> zzgqe2, zzgqe<Context> zzgqe3, zzgqe<zzcik> zzgqe4, zzgqe<ScheduledExecutorService> zzgqe5, zzgqe<Executor> zzgqe6, zzgqe<String> zzgqe7) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzewr(new zzcic(), ((zzexo) this.zzb).zzb().intValue(), ((zzcqr) this.zzc).zza(), this.zzd.zzb(), this.zze.zzb(), zzfxb, ((zzexn) this.zzg).zza(), (byte[]) null);
    }
}
