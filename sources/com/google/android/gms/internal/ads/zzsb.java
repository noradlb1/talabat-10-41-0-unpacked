package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public class zzsb {
    protected final zzcf zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzab[] zzd;
    private int zze;

    public zzsb(zzcf zzcf, int[] iArr, int i11) {
        boolean z11;
        int length = iArr.length;
        if (length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        zzcf.getClass();
        this.zza = zzcf;
        this.zzb = length;
        this.zzd = new zzab[length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            this.zzd[i12] = zzcf.zzb(iArr[i12]);
        }
        Arrays.sort(this.zzd, zzsa.zza);
        this.zzc = new int[this.zzb];
        for (int i13 = 0; i13 < this.zzb; i13++) {
            this.zzc[i13] = zzcf.zza(this.zzd[i13]);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzsb zzsb = (zzsb) obj;
            if (this.zza != zzsb.zza || !Arrays.equals(this.zzc, zzsb.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zze;
        if (i11 != 0) {
            return i11;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = identityHashCode;
        return identityHashCode;
    }

    public final int zzb(int i11) {
        return this.zzc[0];
    }

    public final int zzc() {
        return this.zzc.length;
    }

    public final zzab zzd(int i11) {
        return this.zzd[i11];
    }

    public final zzcf zze() {
        return this.zza;
    }
}
