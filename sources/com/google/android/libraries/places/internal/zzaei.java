package com.google.android.libraries.places.internal;

import sun.misc.Unsafe;

final class zzaei extends zzaek {
    public zzaei(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j11) {
        return Double.longBitsToDouble(zzk(obj, j11));
    }

    public final float zzb(Object obj, long j11) {
        return Float.intBitsToFloat(zzj(obj, j11));
    }

    public final void zzc(Object obj, long j11, boolean z11) {
        if (zzael.zzb) {
            zzael.zzD(obj, j11, r3 ? (byte) 1 : 0);
        } else {
            zzael.zzE(obj, j11, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j11, byte b11) {
        if (zzael.zzb) {
            zzael.zzD(obj, j11, b11);
        } else {
            zzael.zzE(obj, j11, b11);
        }
    }

    public final void zze(Object obj, long j11, double d11) {
        zzo(obj, j11, Double.doubleToLongBits(d11));
    }

    public final void zzf(Object obj, long j11, float f11) {
        zzn(obj, j11, Float.floatToIntBits(f11));
    }

    public final boolean zzg(Object obj, long j11) {
        if (zzael.zzb) {
            return zzael.zzt(obj, j11);
        }
        return zzael.zzu(obj, j11);
    }
}
