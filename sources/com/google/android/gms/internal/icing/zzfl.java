package com.google.android.gms.internal.icing;

import sun.misc.Unsafe;

final class zzfl extends zzfm {
    public zzfl(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object obj, long j11, byte b11) {
        if (zzfn.zzb) {
            zzfn.zzD(obj, j11, b11);
        } else {
            zzfn.zzE(obj, j11, b11);
        }
    }

    public final boolean zzb(Object obj, long j11) {
        if (zzfn.zzb) {
            return zzfn.zzv(obj, j11);
        }
        return zzfn.zzw(obj, j11);
    }

    public final void zzc(Object obj, long j11, boolean z11) {
        if (zzfn.zzb) {
            zzfn.zzD(obj, j11, r3 ? (byte) 1 : 0);
        } else {
            zzfn.zzE(obj, j11, r3 ? (byte) 1 : 0);
        }
    }

    public final float zzd(Object obj, long j11) {
        return Float.intBitsToFloat(zzk(obj, j11));
    }

    public final void zze(Object obj, long j11, float f11) {
        zzl(obj, j11, Float.floatToIntBits(f11));
    }

    public final double zzf(Object obj, long j11) {
        return Double.longBitsToDouble(zzm(obj, j11));
    }

    public final void zzg(Object obj, long j11, double d11) {
        zzn(obj, j11, Double.doubleToLongBits(d11));
    }
}
