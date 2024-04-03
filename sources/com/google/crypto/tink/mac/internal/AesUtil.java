package com.google.crypto.tink.mac.internal;

import java.util.Arrays;

public final class AesUtil {
    public static final int BLOCK_SIZE = 16;

    private AesUtil() {
    }

    public static byte[] cmacPad(byte[] bArr) {
        if (bArr.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[bArr.length] = Byte.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static byte[] dbl(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i11 = 0; i11 < 16; i11++) {
                byte b11 = (byte) ((bArr[i11] << 1) & 254);
                bArr2[i11] = b11;
                if (i11 < 15) {
                    bArr2[i11] = (byte) (((byte) ((bArr[i11 + 1] >> 7) & 1)) | b11);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
