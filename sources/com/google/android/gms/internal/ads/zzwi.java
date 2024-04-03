package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzwi implements zzxp {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzwi(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length > 0) {
            int i11 = length - 1;
            this.zzf = jArr2[i11] + jArr3[i11];
            return;
        }
        this.zzf = 0;
    }

    public final String toString() {
        int i11 = this.zza;
        String arrays = Arrays.toString(this.zzb);
        String arrays2 = Arrays.toString(this.zzc);
        String arrays3 = Arrays.toString(this.zze);
        String arrays4 = Arrays.toString(this.zzd);
        int length = String.valueOf(arrays).length();
        int length2 = String.valueOf(arrays2).length();
        StringBuilder sb2 = new StringBuilder(length + 71 + length2 + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb2.append("ChunkIndex(length=");
        sb2.append(i11);
        sb2.append(", sizes=");
        sb2.append(arrays);
        sb2.append(", offsets=");
        sb2.append(arrays2);
        sb2.append(", timeUs=");
        sb2.append(arrays3);
        sb2.append(", durationsUs=");
        sb2.append(arrays4);
        sb2.append(")");
        return sb2.toString();
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzxn zzg(long j11) {
        int zzd2 = zzfn.zzd(this.zze, j11, true, true);
        zzxq zzxq = new zzxq(this.zze[zzd2], this.zzc[zzd2]);
        if (zzxq.zzb >= j11 || zzd2 == this.zza - 1) {
            return new zzxn(zzxq, zzxq);
        }
        int i11 = zzd2 + 1;
        return new zzxn(zzxq, new zzxq(this.zze[i11], this.zzc[i11]));
    }

    public final boolean zzh() {
        return true;
    }
}
