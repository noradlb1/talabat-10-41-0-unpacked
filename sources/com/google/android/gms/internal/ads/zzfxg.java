package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzfxg extends zzfxd implements ScheduledExecutorService {
    final ScheduledExecutorService zza;

    public zzfxg(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
        zzfxp zza2 = zzfxp.zza(runnable, null);
        return new zzfxe(zza2, this.zza.schedule(zza2, j11, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        zzfxf zzfxf = new zzfxf(runnable);
        return new zzfxe(zzfxf, this.zza.scheduleAtFixedRate(zzfxf, j11, j12, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        zzfxf zzfxf = new zzfxf(runnable);
        return new zzfxe(zzfxf, this.zza.scheduleWithFixedDelay(zzfxf, j11, j12, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j11, TimeUnit timeUnit) {
        zzfxp zzfxp = new zzfxp(callable);
        return new zzfxe(zzfxp, this.zza.schedule(zzfxp, j11, timeUnit));
    }
}
