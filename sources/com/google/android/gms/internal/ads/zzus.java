package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

final class zzus {
    private zzur zza = new zzur();
    private zzur zzb = new zzur();
    private boolean zzc;
    private long zzd = C.TIME_UNSET;
    private int zze;

    public final float zza() {
        if (this.zza.zzf()) {
            return (float) (1.0E9d / ((double) this.zza.zza()));
        }
        return -1.0f;
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        if (this.zza.zzf()) {
            return this.zza.zza();
        }
        return C.TIME_UNSET;
    }

    public final long zzd() {
        if (this.zza.zzf()) {
            return this.zza.zzb();
        }
        return C.TIME_UNSET;
    }

    public final void zze(long j11) {
        this.zza.zzc(j11);
        int i11 = 0;
        if (this.zza.zzf()) {
            this.zzc = false;
        } else if (this.zzd != C.TIME_UNSET) {
            if (!this.zzc || this.zzb.zze()) {
                this.zzb.zzd();
                this.zzb.zzc(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzc(j11);
        }
        if (this.zzc && this.zzb.zzf()) {
            zzur zzur = this.zza;
            this.zza = this.zzb;
            this.zzb = zzur;
            this.zzc = false;
        }
        this.zzd = j11;
        if (!this.zza.zzf()) {
            i11 = this.zze + 1;
        }
        this.zze = i11;
    }

    public final void zzf() {
        this.zza.zzd();
        this.zzb.zzd();
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
        this.zze = 0;
    }

    public final boolean zzg() {
        return this.zza.zzf();
    }
}
