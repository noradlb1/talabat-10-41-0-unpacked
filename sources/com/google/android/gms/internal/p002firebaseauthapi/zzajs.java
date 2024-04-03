package com.google.android.gms.internal.p002firebaseauthapi;

import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajs  reason: invalid package */
final class zzajs extends zzaju {
    public zzajs(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j11) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j11));
    }

    public final float zzb(Object obj, long j11) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j11));
    }

    public final void zzc(Object obj, long j11, boolean z11) {
        if (zzajv.zzb) {
            zzajv.zzD(obj, j11, r3 ? (byte) 1 : 0);
        } else {
            zzajv.zzE(obj, j11, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j11, byte b11) {
        if (zzajv.zzb) {
            zzajv.zzD(obj, j11, b11);
        } else {
            zzajv.zzE(obj, j11, b11);
        }
    }

    public final void zze(Object obj, long j11, double d11) {
        this.zza.putLong(obj, j11, Double.doubleToLongBits(d11));
    }

    public final void zzf(Object obj, long j11, float f11) {
        this.zza.putInt(obj, j11, Float.floatToIntBits(f11));
    }

    public final boolean zzg(Object obj, long j11) {
        if (zzajv.zzb) {
            return zzajv.zzt(obj, j11);
        }
        return zzajv.zzu(obj, j11);
    }
}
