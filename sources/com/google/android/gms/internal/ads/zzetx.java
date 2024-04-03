package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzevm;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzetx<S extends zzevm> implements zzevn<S> {
    private final zzevn<S> zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzetx(zzevn<S> zzevn, long j11, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzevn;
        this.zzb = j11;
        this.zzc = scheduledExecutorService;
    }

    public final zzfxa<S> zzb() {
        zzfxa<S> zzb2 = this.zza.zzb();
        long j11 = this.zzb;
        if (j11 > 0) {
            zzb2 = zzfwq.zzo(zzb2, j11, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzfwq.zzg(zzb2, Throwable.class, zzetw.zza, zzcjm.zzf);
    }
}
