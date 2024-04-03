package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeoutException;

public final class zzii {
    private final zzih zza;
    private final zzig zzb;
    private final zzdz zzc;
    private final zzcd zzd;
    private int zze;
    @Nullable
    private Object zzf;
    private final Looper zzg;
    private final int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public zzii(zzig zzig, zzih zzih, zzcd zzcd, int i11, zzdz zzdz, Looper looper) {
        this.zzb = zzig;
        this.zza = zzih;
        this.zzd = zzcd;
        this.zzg = looper;
        this.zzc = zzdz;
        this.zzh = i11;
    }

    public final int zza() {
        return this.zze;
    }

    public final Looper zzb() {
        return this.zzg;
    }

    public final zzih zzc() {
        return this.zza;
    }

    public final zzii zzd() {
        zzdy.zzf(!this.zzi);
        this.zzi = true;
        this.zzb.zzm(this);
        return this;
    }

    public final zzii zze(@Nullable Object obj) {
        zzdy.zzf(!this.zzi);
        this.zzf = obj;
        return this;
    }

    public final zzii zzf(int i11) {
        zzdy.zzf(!this.zzi);
        this.zze = i11;
        return this;
    }

    @Nullable
    public final Object zzg() {
        return this.zzf;
    }

    public final synchronized void zzh(boolean z11) {
        this.zzj = z11 | this.zzj;
        this.zzk = true;
        notifyAll();
    }

    public final synchronized boolean zzi(long j11) throws InterruptedException, TimeoutException {
        boolean z11;
        zzdy.zzf(this.zzi);
        if (this.zzg.getThread() != Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j12 = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        long j13 = elapsedRealtime + ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        while (!this.zzk) {
            if (j12 > 0) {
                wait(j12);
                j12 = j13 - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
        return this.zzj;
    }

    public final synchronized boolean zzj() {
        return false;
    }
}
