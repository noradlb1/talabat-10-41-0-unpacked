package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzur {
    private long zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private final boolean[] zzg = new boolean[15];
    private int zzh;

    public final long zza() {
        long j11 = this.zze;
        if (j11 == 0) {
            return 0;
        }
        return this.zzf / j11;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final void zzc(long j11) {
        long j12 = this.zzd;
        if (j12 == 0) {
            this.zza = j11;
        } else if (j12 == 1) {
            long j13 = j11 - this.zza;
            this.zzb = j13;
            this.zzf = j13;
            this.zze = 1;
        } else {
            long j14 = j11 - this.zzc;
            int i11 = (int) (j12 % 15);
            if (Math.abs(j14 - this.zzb) <= 1000000) {
                this.zze++;
                this.zzf += j14;
                boolean[] zArr = this.zzg;
                if (zArr[i11]) {
                    zArr[i11] = false;
                    this.zzh--;
                }
            } else {
                boolean[] zArr2 = this.zzg;
                if (!zArr2[i11]) {
                    zArr2[i11] = true;
                    this.zzh++;
                }
            }
        }
        this.zzd++;
        this.zzc = j11;
    }

    public final void zzd() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzh = 0;
        Arrays.fill(this.zzg, false);
    }

    public final boolean zze() {
        long j11 = this.zzd;
        if (j11 == 0) {
            return false;
        }
        return this.zzg[(int) ((j11 - 1) % 15)];
    }

    public final boolean zzf() {
        return this.zzd > 15 && this.zzh == 0;
    }
}
