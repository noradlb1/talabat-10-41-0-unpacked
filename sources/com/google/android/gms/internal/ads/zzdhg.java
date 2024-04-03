package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzdhg extends zzdkb<zzdhh> {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    @GuardedBy("this")
    private long zzd = -1;
    @GuardedBy("this")
    private long zze = -1;
    @GuardedBy("this")
    private boolean zzf = false;
    @GuardedBy("this")
    @Nullable
    private ScheduledFuture<?> zzg;

    public zzdhg(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
    }

    private final synchronized void zze(long j11) {
        ScheduledFuture<?> scheduledFuture = this.zzg;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.zzg.cancel(true);
        }
        this.zzd = this.zzc.elapsedRealtime() + j11;
        this.zzg = this.zzb.schedule(new zzdhf(this, (zzdhe) null), j11, TimeUnit.MILLISECONDS);
    }

    public final synchronized void zza() {
        this.zzf = false;
        zze(0);
    }

    public final synchronized void zzb() {
        if (!this.zzf) {
            ScheduledFuture<?> scheduledFuture = this.zzg;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zze = -1;
            } else {
                this.zzg.cancel(true);
                this.zze = this.zzd - this.zzc.elapsedRealtime();
            }
            this.zzf = true;
        }
    }

    public final synchronized void zzc() {
        if (this.zzf) {
            if (this.zze > 0 && this.zzg.isCancelled()) {
                zze(this.zze);
            }
            this.zzf = false;
        }
    }

    public final synchronized void zzd(int i11) {
        if (i11 > 0) {
            long millis = TimeUnit.SECONDS.toMillis((long) i11);
            if (this.zzf) {
                long j11 = this.zze;
                if (j11 <= 0 || millis >= j11) {
                    millis = j11;
                }
                this.zze = millis;
                return;
            }
            long elapsedRealtime = this.zzc.elapsedRealtime();
            long j12 = this.zzd;
            if (elapsedRealtime > j12 || j12 - this.zzc.elapsedRealtime() > millis) {
                zze(millis);
            }
        }
    }
}
