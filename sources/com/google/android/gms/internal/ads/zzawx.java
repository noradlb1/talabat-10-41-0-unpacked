package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzawx implements zzawq {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzapk zzd = zzapk.zza;

    public final long zzI() {
        long j11;
        long j12 = this.zzb;
        if (!this.zza) {
            return j12;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzapk zzapk = this.zzd;
        if (zzapk.zzb == 1.0f) {
            j11 = zzaor.zza(elapsedRealtime);
        } else {
            j11 = zzapk.zza(elapsedRealtime);
        }
        return j12 + j11;
    }

    public final zzapk zzJ() {
        throw null;
    }

    public final zzapk zzK(zzapk zzapk) {
        if (this.zza) {
            zza(zzI());
        }
        this.zzd = zzapk;
        return zzapk;
    }

    public final void zza(long j11) {
        this.zzb = j11;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    public final void zzb() {
        if (!this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
            this.zza = true;
        }
    }

    public final void zzc() {
        if (this.zza) {
            zza(zzI());
            this.zza = false;
        }
    }

    public final void zzd(zzawq zzawq) {
        zza(zzawq.zzI());
        this.zzd = zzawq.zzJ();
    }
}
