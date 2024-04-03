package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzewe implements zzgpr<zzewc> {
    private final zzgqe<zzcic> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<ScheduledExecutorService> zzc;
    private final zzgqe<Executor> zzd;
    private final zzgqe<Integer> zze;

    public zzewe(zzgqe<zzcic> zzgqe, zzgqe<Context> zzgqe2, zzgqe<ScheduledExecutorService> zzgqe3, zzgqe<Executor> zzgqe4, zzgqe<Integer> zzgqe5) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzewc(new zzcic(), ((zzcqr) this.zzb).zza(), this.zzc.zzb(), zzfxb, ((zzexo) this.zze).zzb().intValue(), (byte[]) null);
    }
}
