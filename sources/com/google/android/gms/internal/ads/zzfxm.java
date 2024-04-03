package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

final class zzfxm<V> extends zzfwg<V> {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzfxa<V> zza;
    /* access modifiers changed from: private */
    @CheckForNull
    public ScheduledFuture<?> zzb;

    private zzfxm(zzfxa<V> zzfxa) {
        zzfxa.getClass();
        this.zza = zzfxa;
    }

    public static <V> zzfxa<V> zzb(zzfxa<V> zzfxa, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzfxm zzfxm = new zzfxm(zzfxa);
        zzfxj zzfxj = new zzfxj(zzfxm);
        zzfxm.zzb = scheduledExecutorService.schedule(zzfxj, j11, timeUnit);
        zzfxa.zzc(zzfxj, zzfwe.INSTANCE);
        return zzfxm;
    }

    @CheckForNull
    public final String zzd() {
        zzfxa<V> zzfxa = this.zza;
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (zzfxa == null) {
            return null;
        }
        String obj = zzfxa.toString();
        StringBuilder sb2 = new StringBuilder(obj.length() + 14);
        sb2.append("inputFuture=[");
        sb2.append(obj);
        sb2.append("]");
        String sb3 = sb2.toString();
        if (scheduledFuture == null) {
            return sb3;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb3;
        }
        StringBuilder sb4 = new StringBuilder(sb3.length() + 43);
        sb4.append(sb3);
        sb4.append(", remaining delay=[");
        sb4.append(delay);
        sb4.append(" ms]");
        return sb4.toString();
    }

    public final void zze() {
        zzq(this.zza);
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
