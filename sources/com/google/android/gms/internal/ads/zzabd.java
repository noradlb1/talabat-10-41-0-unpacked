package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.C;

final class zzabd implements zzabi {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzabd(long[] jArr, long[] jArr2, long j11) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j11 == C.TIME_UNSET ? zzk.zzc(jArr2[jArr2.length - 1]) : j11;
    }

    public static zzabd zza(long j11, zzzy zzzy, long j12) {
        int length = zzzy.zzd.length;
        int i11 = length + 1;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        jArr[0] = j11;
        long j13 = 0;
        jArr2[0] = 0;
        for (int i12 = 1; i12 <= length; i12++) {
            int i13 = i12 - 1;
            j11 += (long) (zzzy.zzb + zzzy.zzd[i13]);
            j13 += (long) (zzzy.zzc + zzzy.zze[i13]);
            jArr[i12] = j11;
            jArr2[i12] = j13;
        }
        return new zzabd(jArr, jArr2, j12);
    }

    private static Pair<Long, Long> zzd(long j11, long[] jArr, long[] jArr2) {
        double d11;
        int zzd = zzfn.zzd(jArr, j11, true, true);
        long j12 = jArr[zzd];
        long j13 = jArr2[zzd];
        int i11 = zzd + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        long j14 = jArr[i11];
        long j15 = jArr2[i11];
        if (j14 == j12) {
            d11 = 0.0d;
        } else {
            d11 = (((double) j11) - ((double) j12)) / ((double) (j14 - j12));
        }
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) (d11 * ((double) (j15 - j13)))) + j13));
    }

    public final long zzb() {
        return -1;
    }

    public final long zzc(long j11) {
        return zzk.zzc(((Long) zzd(j11, this.zza, this.zzb).second).longValue());
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzxn zzg(long j11) {
        Pair<Long, Long> zzd = zzd(zzk.zzd(zzfn.zzo(j11, 0, this.zzc)), this.zzb, this.zza);
        zzxq zzxq = new zzxq(zzk.zzc(((Long) zzd.first).longValue()), ((Long) zzd.second).longValue());
        return new zzxn(zzxq, zzxq);
    }

    public final boolean zzh() {
        return true;
    }
}
