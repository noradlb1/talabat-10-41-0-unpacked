package com.google.android.gms.internal.ads;

public final class zzapk {
    public static final zzapk zza = new zzapk(1.0f, 1.0f);
    public final float zzb;
    public final float zzc = 1.0f;
    private final int zzd;

    public zzapk(float f11, float f12) {
        this.zzb = f11;
        this.zzd = Math.round(f11 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzapk.class == obj.getClass() && this.zzb == ((zzapk) obj).zzb;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzb) + 527) * 31) + Float.floatToRawIntBits(1.0f);
    }

    public final long zza(long j11) {
        return j11 * ((long) this.zzd);
    }
}
