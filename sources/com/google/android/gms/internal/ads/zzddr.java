package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzddr implements zzder, zzdlo, zzdjm, zzdfh {
    /* access modifiers changed from: private */
    public final zzdfj zza;
    private final zzfdn zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzfxi<Boolean> zze = zzfxi.zza();
    private ScheduledFuture<?> zzf;

    public zzddr(zzdfj zzdfj, zzfdn zzfdn, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = zzdfj;
        this.zzb = zzfdn;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    public final /* synthetic */ void zzb() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzs(Boolean.TRUE);
            }
        }
    }

    public final void zzbD() {
    }

    public final void zzc() {
    }

    public final synchronized void zzd() {
        if (!this.zze.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzs(Boolean.TRUE);
        }
    }

    public final void zze() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbg)).booleanValue()) {
            zzfdn zzfdn = this.zzb;
            if (zzfdn.zzV != 2) {
                return;
            }
            if (zzfdn.zzr == 0) {
                this.zza.zza();
                return;
            }
            zzfwq.zzr(this.zze, new zzddq(this), this.zzd);
            this.zzf = this.zzc.schedule(new zzddp(this), (long) this.zzb.zzr, TimeUnit.MILLISECONDS);
        }
    }

    public final void zzf() {
    }

    public final void zzj() {
    }

    public final synchronized void zzk(zzbew zzbew) {
        if (!this.zze.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzt(new Exception());
        }
    }

    public final void zzm() {
    }

    public final void zzo() {
        int i11 = this.zzb.zzV;
        if (i11 == 0 || i11 == 1) {
            this.zza.zza();
        }
    }

    public final void zzp(zzceg zzceg, String str, String str2) {
    }

    public final void zzr() {
    }
}
