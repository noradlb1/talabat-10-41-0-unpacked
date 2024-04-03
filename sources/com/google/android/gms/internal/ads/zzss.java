package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

public final class zzss {
    private final String[] zza;
    private final int[] zzb;
    private final zzch[] zzc;
    private final int[] zzd;
    private final int[][][] zze;
    private final zzch zzf;

    @VisibleForTesting
    public zzss(String[] strArr, int[] iArr, zzch[] zzchArr, int[] iArr2, int[][][] iArr3, zzch zzch) {
        this.zza = strArr;
        this.zzb = iArr;
        this.zzc = zzchArr;
        this.zze = iArr3;
        this.zzd = iArr2;
        this.zzf = zzch;
    }

    public final int zza(int i11) {
        return this.zzb[i11];
    }

    public final int zzb(int i11, int i12, int i13) {
        return this.zze[i11][i12][0] & 7;
    }

    public final zzch zzc(int i11) {
        return this.zzc[i11];
    }

    public final zzch zzd() {
        return this.zzf;
    }
}
