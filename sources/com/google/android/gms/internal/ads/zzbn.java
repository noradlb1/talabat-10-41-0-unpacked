package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

public final class zzbn {
    public static final zzbn zza = new zzbn(1.0f, 1.0f);
    public static final zzj<zzbn> zzb = zzbm.zza;
    public final float zzc;
    public final float zzd;
    private final int zze;

    public zzbn(@FloatRange(from = 0.0d, fromInclusive = false) float f11, @FloatRange(from = 0.0d, fromInclusive = false) float f12) {
        boolean z11;
        boolean z12 = true;
        if (f11 > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        zzdy.zzd(f12 <= 0.0f ? false : z12);
        this.zzc = f11;
        this.zzd = f12;
        this.zze = Math.round(f11 * 1000.0f);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbn.class == obj.getClass()) {
            zzbn zzbn = (zzbn) obj;
            return this.zzc == zzbn.zzc && this.zzd == zzbn.zzd;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzc) + 527) * 31) + Float.floatToRawIntBits(this.zzd);
    }

    public final String toString() {
        return zzfn.zzD("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.zzc), Float.valueOf(this.zzd));
    }

    public final long zza(long j11) {
        return j11 * ((long) this.zze);
    }
}
