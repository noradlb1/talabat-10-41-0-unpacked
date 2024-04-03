package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcwv implements zzgpr<zzcwu> {
    private final zzgqe<Context> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<Executor> zzc;
    private final zzgqe<ScheduledExecutorService> zzd;
    private final zzgqe<zzfdz> zze;
    private final zzgqe<zzfdn> zzf;
    private final zzgqe<zzfjp> zzg;
    private final zzgqe<zzfeo> zzh;
    private final zzgqe<View> zzi;
    private final zzgqe<zzalt> zzj;
    private final zzgqe<zzbmi> zzk;
    private final zzgqe<zzbmk> zzl;

    public zzcwv(zzgqe<Context> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<Executor> zzgqe3, zzgqe<ScheduledExecutorService> zzgqe4, zzgqe<zzfdz> zzgqe5, zzgqe<zzfdn> zzgqe6, zzgqe<zzfjp> zzgqe7, zzgqe<zzfeo> zzgqe8, zzgqe<View> zzgqe9, zzgqe<zzalt> zzgqe10, zzgqe<zzbmi> zzgqe11, zzgqe<zzbmk> zzgqe12) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
        this.zzi = zzgqe9;
        this.zzj = zzgqe10;
        this.zzk = zzgqe11;
        this.zzl = zzgqe12;
    }

    public final /* synthetic */ Object zzb() {
        Context zza2 = ((zzffh) this.zza).zza();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzcwu(zza2, zzfxb, this.zzc.zzb(), this.zzd.zzb(), ((zzdbo) this.zze).zza(), ((zzdbl) this.zzf).zza(), this.zzg.zzb(), this.zzh.zzb(), this.zzi.zzb(), this.zzj.zzb(), this.zzk.zzb(), new zzbmk(), (byte[]) null);
    }
}
