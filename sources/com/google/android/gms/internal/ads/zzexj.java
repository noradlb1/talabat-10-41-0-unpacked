package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzexj implements zzevn<zzexk> {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzcbw zzc;

    public zzexj(zzcbw zzcbw, ScheduledExecutorService scheduledExecutorService, Context context, byte[] bArr) {
        this.zzc = zzcbw;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final zzfxa<zzexk> zzb() {
        return zzfwq.zzm(zzfwq.zzo(zzfwq.zzi(new Bundle()), ((Long) zzbgq.zzc().zzb(zzblj.zzcF)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzexi.zza, zzcjm.zza);
    }
}
