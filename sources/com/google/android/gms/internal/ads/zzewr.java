package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzewr implements zzevn<zzews> {
    private final Context zza;
    private final zzcik zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final String zze;
    private final zzcic zzf;

    public zzewr(zzcic zzcic, int i11, Context context, zzcik zzcik, ScheduledExecutorService scheduledExecutorService, Executor executor, String str, byte[] bArr) {
        this.zzf = zzcic;
        this.zza = context;
        this.zzb = zzcik;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zze = str;
    }

    public final /* synthetic */ zzews zza(Exception exc) {
        this.zzb.zzs(exc, "AttestationTokenSignal");
        return null;
    }

    public final zzfxa<zzews> zzb() {
        return zzfwq.zzf((zzfwh) zzfwq.zzo(zzfwq.zzm(zzfwh.zzw(zzfwq.zzl(new zzewq(this), this.zzd)), zzewp.zza, this.zzd), ((Long) zzbgq.zzc().zzb(zzblj.zzaJ)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzewo(this), zzfxh.zzb());
    }
}
