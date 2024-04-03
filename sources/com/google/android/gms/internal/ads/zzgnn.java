package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzgnn extends zzgno {
    public zzgnn(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(long j11) {
        return Memory.peekByte(j11);
    }

    public final double zzb(Object obj, long j11) {
        return Double.longBitsToDouble(zzm(obj, j11));
    }

    public final float zzc(Object obj, long j11) {
        return Float.intBitsToFloat(zzl(obj, j11));
    }

    public final void zzd(long j11, byte[] bArr, long j12, long j13) {
        Memory.peekByteArray(j11, bArr, (int) j12, (int) j13);
    }

    public final void zze(Object obj, long j11, boolean z11) {
        if (zzgnp.zzb) {
            zzgnp.zzG(obj, j11, r3 ? (byte) 1 : 0);
        } else {
            zzgnp.zzH(obj, j11, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzf(Object obj, long j11, byte b11) {
        if (zzgnp.zzb) {
            zzgnp.zzG(obj, j11, b11);
        } else {
            zzgnp.zzH(obj, j11, b11);
        }
    }

    public final void zzg(Object obj, long j11, double d11) {
        zzq(obj, j11, Double.doubleToLongBits(d11));
    }

    public final void zzh(Object obj, long j11, float f11) {
        zzp(obj, j11, Float.floatToIntBits(f11));
    }

    public final boolean zzi(Object obj, long j11) {
        if (zzgnp.zzb) {
            return zzgnp.zzw(obj, j11);
        }
        return zzgnp.zzx(obj, j11);
    }
}
