package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class Bytes {
    private Bytes() {
    }

    public static int byteArrayToInt(byte[] bArr) {
        return byteArrayToInt(bArr, bArr.length);
    }

    public static byte[] concat(byte[]... bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            byte[] bArr2 = bArr[i11];
            if (i12 <= Integer.MAX_VALUE - bArr2.length) {
                i12 += bArr2.length;
                i11++;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr3 = new byte[i12];
        int i13 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i13, bArr4.length);
            i13 += bArr4.length;
        }
        return bArr3;
    }

    public static final boolean equal(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        byte b11 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            b11 |= bArr[i11] ^ bArr2[i11];
        }
        if (b11 == 0) {
            return true;
        }
        return false;
    }

    public static byte[] intToByteArray(int i11, int i12) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) ((i12 >> (i13 * 8)) & 255);
        }
        return bArr;
    }

    public static final byte[] xor(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        if (i13 < 0 || bArr.length - i13 < i11 || bArr2.length - i13 < i12) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            bArr3[i14] = (byte) (bArr[i14 + i11] ^ bArr2[i14 + i12]);
        }
        return bArr3;
    }

    public static final byte[] xorEnd(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= bArr2.length) {
            int length = bArr.length - bArr2.length;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                int i12 = length + i11;
                copyOf[i12] = (byte) (copyOf[i12] ^ bArr2[i11]);
            }
            return copyOf;
        }
        throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
    }

    public static int byteArrayToInt(byte[] bArr, int i11) {
        return byteArrayToInt(bArr, 0, i11);
    }

    public static int byteArrayToInt(byte[] bArr, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            i13 += (bArr[i14 + i11] & 255) << (i14 * 8);
        }
        return i13;
    }

    public static final void xor(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i11) {
        if (i11 < 0 || byteBuffer2.remaining() < i11 || byteBuffer3.remaining() < i11 || byteBuffer.remaining() < i11) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] xor(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return xor(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }
}
