package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzdfe extends zzdkb<zzdev> implements zzdev {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture<?> zzc;
    private boolean zzd = false;
    private final boolean zze;

    public zzdfe(zzdfd zzdfd, Set<zzdlw<zzdev>> set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        this.zze = ((Boolean) zzbgq.zzc().zzb(zzblj.zzhi)).booleanValue();
        zzj(zzdfd, executor);
    }

    public final void zza(zzbew zzbew) {
        zzo(new zzdew(zzbew));
    }

    public final void zzb() {
        zzo(zzdey.zza);
    }

    public final /* synthetic */ void zzc() {
        synchronized (this) {
            zzciz.zzg("Timeout waiting for show call succeed to be called.");
            zze(new zzdoa("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zzd() {
        if (this.zze) {
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }
    }

    public final void zze(zzdoa zzdoa) {
        if (this.zze) {
            if (!this.zzd) {
                ScheduledFuture<?> scheduledFuture = this.zzc;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            } else {
                return;
            }
        }
        zzo(new zzdex(zzdoa));
    }

    public final void zzf() {
        if (this.zze) {
            this.zzc = this.zzb.schedule(new zzdez(this), (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzhj)).intValue(), TimeUnit.MILLISECONDS);
        }
    }
}
