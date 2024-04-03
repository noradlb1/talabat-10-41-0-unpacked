package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

public class zzwj implements zzxp {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzwj(long j11, long j12, int i11, int i12, boolean z11) {
        long zzb2;
        this.zza = j11;
        this.zzb = j12;
        this.zzc = i12 == -1 ? 1 : i12;
        this.zze = i11;
        if (j11 == -1) {
            this.zzd = -1;
            zzb2 = C.TIME_UNSET;
        } else {
            this.zzd = j11 - j12;
            zzb2 = zzb(j11, j12, i11);
        }
        this.zzf = zzb2;
    }

    private static long zzb(long j11, long j12, int i11) {
        return (Math.max(0, j11 - j12) * 8000000) / ((long) i11);
    }

    public final long zza(long j11) {
        return zzb(j11, this.zzb, this.zze);
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzxn zzg(long j11) {
        long j12 = this.zzd;
        int i11 = (j12 > -1 ? 1 : (j12 == -1 ? 0 : -1));
        if (i11 != 0) {
            int i12 = this.zze;
            long j13 = (long) this.zzc;
            long j14 = (((((long) i12) * j11) / 8000000) / j13) * j13;
            if (i11 != 0) {
                j14 = Math.min(j14, j12 - j13);
            }
            long max = this.zzb + Math.max(j14, 0);
            long zza2 = zza(max);
            zzxq zzxq = new zzxq(zza2, max);
            if (this.zzd != -1 && zza2 < j11) {
                long j15 = max + ((long) this.zzc);
                if (j15 < this.zza) {
                    return new zzxn(zzxq, new zzxq(zza(j15), j15));
                }
            }
            return new zzxn(zzxq, zzxq);
        }
        zzxq zzxq2 = new zzxq(0, this.zzb);
        return new zzxn(zzxq2, zzxq2);
    }

    public final boolean zzh() {
        return this.zzd != -1;
    }
}
