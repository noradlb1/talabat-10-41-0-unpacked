package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public final class zzaie {
    public static double zza(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) (((((bArr[0] << Ascii.CAN) & -16777216) | ((bArr[1] << Ascii.DLE) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255))) / 1.073741824E9d;
    }

    public static double zzb(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) (((((bArr[0] << Ascii.CAN) & -16777216) | ((bArr[1] << Ascii.DLE) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255))) / 65536.0d;
    }

    public static int zzc(byte b11) {
        return b11 < 0 ? b11 + 256 : b11;
    }

    public static int zzd(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static long zze(ByteBuffer byteBuffer) {
        long j11 = (long) byteBuffer.getInt();
        return j11 < 0 ? j11 + 4294967296L : j11;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long zze = zze(byteBuffer) << 32;
        if (zze >= 0) {
            return zze + zze(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
