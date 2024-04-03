package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;

public final class zzgb {
    private final long zza;
    private final long zzb;
    private long zzc = C.TIME_UNSET;
    private long zzd = C.TIME_UNSET;
    private long zze = C.TIME_UNSET;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzi = 1.03f;
    private float zzj = 0.97f;
    private float zzk = 1.0f;
    private long zzl = C.TIME_UNSET;
    private long zzm = C.TIME_UNSET;
    private long zzn = C.TIME_UNSET;

    public /* synthetic */ zzgb(float f11, float f12, long j11, float f13, long j12, long j13, float f14, zzga zzga) {
        this.zza = j12;
        this.zzb = j13;
    }

    private static long zzf(long j11, long j12, float f11) {
        return (long) ((((float) j11) * 0.999f) + (((float) j12) * 9.999871E-4f));
    }

    private final void zzg() {
        long j11 = this.zzc;
        if (j11 != C.TIME_UNSET) {
            long j12 = this.zzd;
            if (j12 != C.TIME_UNSET) {
                j11 = j12;
            }
            long j13 = this.zzf;
            if (j13 != C.TIME_UNSET && j11 < j13) {
                j11 = j13;
            }
            long j14 = this.zzg;
            if (j14 != C.TIME_UNSET && j11 > j14) {
                j11 = j14;
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.zze != j11) {
            this.zze = j11;
            this.zzh = j11;
            this.zzm = C.TIME_UNSET;
            this.zzn = C.TIME_UNSET;
            this.zzl = C.TIME_UNSET;
        }
    }

    public final float zza(long j11, long j12) {
        long j13;
        if (this.zzc == C.TIME_UNSET) {
            return 1.0f;
        }
        long j14 = j11 - j12;
        long j15 = this.zzm;
        if (j15 == C.TIME_UNSET) {
            this.zzm = j14;
            this.zzn = 0;
        } else {
            long max = Math.max(j14, zzf(j15, j14, 0.999f));
            this.zzm = max;
            this.zzn = zzf(this.zzn, Math.abs(j14 - max), 0.999f);
        }
        if (this.zzl != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j16 = this.zzm + (this.zzn * 3);
        if (this.zzh > j16) {
            long zzc2 = zzk.zzc(1000);
            float f11 = (float) zzc2;
            long[] jArr = {j16, this.zze, this.zzh - (((long) ((this.zzk - 4.0f) * f11)) + ((long) ((this.zzi - 4.0f) * f11)))};
            j13 = j16;
            for (int i11 = 1; i11 < 3; i11++) {
                long j17 = jArr[i11];
                if (j17 > j13) {
                    j13 = j17;
                }
            }
            this.zzh = j13;
        } else {
            long zzo = zzfn.zzo(j11 - ((long) (Math.max(0.0f, this.zzk - 4.0f) / 1.0E-7f)), this.zzh, j16);
            this.zzh = zzo;
            long j18 = this.zzg;
            if (j18 == C.TIME_UNSET || zzo <= j18) {
                j13 = zzo;
            } else {
                this.zzh = j18;
                j13 = j18;
            }
        }
        long j19 = j11 - j13;
        if (Math.abs(j19) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float zza2 = zzfn.zza((((float) j19) * 1.0E-7f) + 1.0f, this.zzj, this.zzi);
        this.zzk = zza2;
        return zza2;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j11 = this.zzh;
        if (j11 != C.TIME_UNSET) {
            long j12 = j11 + this.zzb;
            this.zzh = j12;
            long j13 = this.zzg;
            if (j13 != C.TIME_UNSET && j12 > j13) {
                this.zzh = j13;
            }
            this.zzl = C.TIME_UNSET;
        }
    }

    public final void zzd(zzas zzas) {
        long j11 = zzas.zzc;
        this.zzc = zzk.zzc(C.TIME_UNSET);
        this.zzf = zzk.zzc(C.TIME_UNSET);
        this.zzg = zzk.zzc(C.TIME_UNSET);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j11) {
        this.zzd = j11;
        zzg();
    }
}
