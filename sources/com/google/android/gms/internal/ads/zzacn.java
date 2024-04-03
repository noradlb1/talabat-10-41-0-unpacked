package com.google.android.gms.internal.ads;

final class zzacn {
    public final zzack zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzacn(zzack zzack, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        boolean z11;
        boolean z12;
        int length = iArr.length;
        int length2 = jArr2.length;
        boolean z13 = true;
        if (length == length2) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        int length3 = jArr.length;
        if (length3 == length2) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzdy.zzd(z12);
        int length4 = iArr2.length;
        zzdy.zzd(length4 != length2 ? false : z13);
        this.zza = zzack;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i11;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j11;
        this.zzb = length3;
        if (length4 > 0) {
            int i12 = length4 - 1;
            iArr2[i12] = iArr2[i12] | 536870912;
        }
    }

    public final int zza(long j11) {
        for (int zzd2 = zzfn.zzd(this.zzf, j11, true, false); zzd2 >= 0; zzd2--) {
            if ((this.zzg[zzd2] & 1) != 0) {
                return zzd2;
            }
        }
        return -1;
    }

    public final int zzb(long j11) {
        for (int zzb2 = zzfn.zzb(this.zzf, j11, true, false); zzb2 < this.zzf.length; zzb2++) {
            if ((this.zzg[zzb2] & 1) != 0) {
                return zzb2;
            }
        }
        return -1;
    }
}
