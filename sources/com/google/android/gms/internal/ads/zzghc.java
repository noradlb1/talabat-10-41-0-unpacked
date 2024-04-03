package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzghc {
    public static final void zza(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i11) {
        if (i11 < 0 || byteBuffer2.remaining() < i11 || byteBuffer3.remaining() < i11 || byteBuffer.remaining() < i11) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static byte[] zzb(byte[]... bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int length2 = bArr[i11].length;
            if (i12 <= Integer.MAX_VALUE - length2) {
                i12 += length2;
                i11++;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr2 = new byte[i12];
        int i13 = 0;
        for (byte[] bArr3 : bArr) {
            int length3 = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i13, length3);
            i13 += length3;
        }
        return bArr2;
    }

    public static final byte[] zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length == bArr2.length) {
            return zzd(bArr, 0, bArr2, 0, length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] zzd(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        if (bArr.length - i13 < i11 || bArr2.length - i13 < i12) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            bArr3[i14] = (byte) (bArr[i14 + i11] ^ bArr2[i14 + i12]);
        }
        return bArr3;
    }
}
