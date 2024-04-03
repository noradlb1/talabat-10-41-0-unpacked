package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

public final class zzct {
    public static final zzct zza = new zzct(0, 0, 0, 1.0f);
    public static final zzj<zzct> zzb = zzcs.zza;
    @IntRange(from = 0)
    public final int zzc;
    @IntRange(from = 0)
    public final int zzd;
    @IntRange(from = 0, to = 359)
    public final int zze;
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float zzf;

    public zzct(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0, to = 359) int i13, @FloatRange(from = 0.0d, fromInclusive = false) float f11) {
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = f11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzct) {
            zzct zzct = (zzct) obj;
            if (this.zzc == zzct.zzc && this.zzd == zzct.zzd && this.zze == zzct.zze && this.zzf == zzct.zzf) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zzc + 217) * 31) + this.zzd) * 31) + this.zze) * 31) + Float.floatToRawIntBits(this.zzf);
    }
}
