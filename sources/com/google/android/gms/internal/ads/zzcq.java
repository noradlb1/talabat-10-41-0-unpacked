package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzcq {
    public static final zzj<zzcq> zza = zzcp.zza;
    private final zzcf zzb;
    private final int[] zzc;
    private final int zzd;
    private final boolean[] zze;

    public zzcq(zzcf zzcf, int[] iArr, int i11, boolean[] zArr) {
        int i12 = zzcf.zzb;
        this.zzb = zzcf;
        this.zzc = (int[]) iArr.clone();
        this.zzd = i11;
        this.zze = (boolean[]) zArr.clone();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcq.class == obj.getClass()) {
            zzcq zzcq = (zzcq) obj;
            if (this.zzd != zzcq.zzd || !this.zzb.equals(zzcq.zzb) || !Arrays.equals(this.zzc, zzcq.zzc) || !Arrays.equals(this.zze, zzcq.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zzb.hashCode() * 31) + Arrays.hashCode(this.zzc)) * 31) + this.zzd) * 31) + Arrays.hashCode(this.zze);
    }
}
