package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzcxr implements zzayt {
    private final ScheduledExecutorService zza;
    private final Clock zzb;
    @GuardedBy("this")
    @Nullable
    private ScheduledFuture<?> zzc;
    @GuardedBy("this")
    private long zzd = -1;
    @GuardedBy("this")
    private long zze = -1;
    @GuardedBy("this")
    private Runnable zzf = null;
    @GuardedBy("this")
    private boolean zzg = false;

    public zzcxr(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = scheduledExecutorService;
        this.zzb = clock;
        zzt.zzb().zzc(this);
    }

    public final void zza(boolean z11) {
        if (z11) {
            zzc();
        } else {
            zzb();
        }
    }

    @VisibleForTesting
    public final synchronized void zzb() {
        if (!this.zzg) {
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zze = -1;
            } else {
                this.zzc.cancel(true);
                this.zze = this.zzd - this.zzb.elapsedRealtime();
            }
            this.zzg = true;
        }
    }

    @VisibleForTesting
    public final synchronized void zzc() {
        ScheduledFuture<?> scheduledFuture;
        if (this.zzg) {
            if (this.zze > 0 && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
            }
            this.zzg = false;
        }
    }

    public final synchronized void zzd(int i11, Runnable runnable) {
        this.zzf = runnable;
        long j11 = (long) i11;
        this.zzd = this.zzb.elapsedRealtime() + j11;
        this.zzc = this.zza.schedule(runnable, j11, TimeUnit.MILLISECONDS);
    }
}
