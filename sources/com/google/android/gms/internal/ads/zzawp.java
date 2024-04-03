package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzawp {
    private int zza;
    private long[] zzb;

    public zzawp() {
        this(32);
    }

    public zzawp(int i11) {
        this.zzb = new long[32];
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb(int i11) {
        if (i11 >= 0 && i11 < this.zza) {
            return this.zzb[i11];
        }
        int i12 = this.zza;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Invalid index ");
        sb2.append(i11);
        sb2.append(", size is ");
        sb2.append(i12);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public final void zzc(long j11) {
        int i11 = this.zza;
        long[] jArr = this.zzb;
        if (i11 == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i11 + i11);
        }
        long[] jArr2 = this.zzb;
        int i12 = this.zza;
        this.zza = i12 + 1;
        jArr2[i12] = j11;
    }
}
