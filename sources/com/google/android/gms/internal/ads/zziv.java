package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zziv implements zzht {
    private final zzdz zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzbn zze = zzbn.zza;

    public zziv(zzdz zzdz) {
        this.zza = zzdz;
    }

    public final long zza() {
        long j11;
        long j12 = this.zzc;
        if (!this.zzb) {
            return j12;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzbn zzbn = this.zze;
        if (zzbn.zzc == 1.0f) {
            j11 = zzk.zzc(elapsedRealtime);
        } else {
            j11 = zzbn.zza(elapsedRealtime);
        }
        return j12 + j11;
    }

    public final void zzb(long j11) {
        this.zzc = j11;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    public final zzbn zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    public final void zzg(zzbn zzbn) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzbn;
    }
}
