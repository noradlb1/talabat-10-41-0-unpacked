package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;

final class zzke extends zzkf {
    public zzke(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j11) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j11));
    }

    public final float zzb(Object obj, long j11) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j11));
    }

    public final void zzc(Object obj, long j11, boolean z11) {
        if (zzkg.zzb) {
            zzkg.zzD(obj, j11, r3 ? (byte) 1 : 0);
        } else {
            zzkg.zzE(obj, j11, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j11, byte b11) {
        if (zzkg.zzb) {
            zzkg.zzD(obj, j11, b11);
        } else {
            zzkg.zzE(obj, j11, b11);
        }
    }

    public final void zze(Object obj, long j11, double d11) {
        this.zza.putLong(obj, j11, Double.doubleToLongBits(d11));
    }

    public final void zzf(Object obj, long j11, float f11) {
        this.zza.putInt(obj, j11, Float.floatToIntBits(f11));
    }

    public final boolean zzg(Object obj, long j11) {
        if (zzkg.zzb) {
            return zzkg.zzt(obj, j11);
        }
        return zzkg.zzu(obj, j11);
    }
}
