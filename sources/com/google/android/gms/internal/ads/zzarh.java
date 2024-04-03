package com.google.android.gms.internal.ads;

public final class zzarh implements zzarq {
    public final int[] zza;
    public final long[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    private final long zze;

    public zzarh(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = iArr;
        this.zzb = jArr;
        this.zzc = jArr2;
        this.zzd = jArr3;
        int length = iArr.length;
        if (length > 0) {
            int i11 = length - 1;
            this.zze = jArr2[i11] + jArr3[i11];
            return;
        }
        this.zze = 0;
    }

    public final long zza() {
        return this.zze;
    }

    public final long zzb(long j11) {
        return this.zzb[zzaxb.zzc(this.zzd, j11, true, true)];
    }

    public final boolean zzc() {
        return true;
    }
}
