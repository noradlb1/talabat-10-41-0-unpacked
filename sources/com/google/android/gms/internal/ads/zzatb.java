package com.google.android.gms.internal.ads;

final class zzatb {
    public final int zza;
    public final long[] zzb;
    public final int[] zzc;
    public final int zzd;
    public final long[] zze;
    public final int[] zzf;

    public zzatb(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2) {
        boolean z11;
        boolean z12;
        int length = jArr2.length;
        boolean z13 = true;
        if (iArr.length == length) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        int length2 = jArr.length;
        if (length2 == length) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzawm.zzc(z12);
        zzawm.zzc(iArr2.length != length ? false : z13);
        this.zzb = jArr;
        this.zzc = iArr;
        this.zzd = i11;
        this.zze = jArr2;
        this.zzf = iArr2;
        this.zza = length2;
    }

    public final int zza(long j11) {
        for (int zzc2 = zzaxb.zzc(this.zze, j11, true, false); zzc2 >= 0; zzc2--) {
            if ((this.zzf[zzc2] & 1) != 0) {
                return zzc2;
            }
        }
        return -1;
    }

    public final int zzb(long j11) {
        for (int zzb2 = zzaxb.zzb(this.zze, j11, true, false); zzb2 < this.zze.length; zzb2++) {
            if ((this.zzf[zzb2] & 1) != 0) {
                return zzb2;
            }
        }
        return -1;
    }
}
