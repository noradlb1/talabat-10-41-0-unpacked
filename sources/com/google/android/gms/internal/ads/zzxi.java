package com.google.android.gms.internal.ads;

public final class zzxi implements zzxp {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzxi(long[] jArr, long[] jArr2, long j11) {
        boolean z11;
        boolean z12;
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length == length2) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        if (length2 > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.zzd = z12;
        if (!z12 || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i11 = length2 + 1;
            long[] jArr3 = new long[i11];
            this.zza = jArr3;
            long[] jArr4 = new long[i11];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.zzc = j11;
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzxn zzg(long j11) {
        if (!this.zzd) {
            zzxq zzxq = zzxq.zza;
            return new zzxn(zzxq, zzxq);
        }
        int zzd2 = zzfn.zzd(this.zzb, j11, true, true);
        zzxq zzxq2 = new zzxq(this.zzb[zzd2], this.zza[zzd2]);
        if (zzxq2.zzb != j11) {
            long[] jArr = this.zzb;
            if (zzd2 != jArr.length - 1) {
                int i11 = zzd2 + 1;
                return new zzxn(zzxq2, new zzxq(jArr[i11], this.zza[i11]));
            }
        }
        return new zzxn(zzxq2, zzxq2);
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
