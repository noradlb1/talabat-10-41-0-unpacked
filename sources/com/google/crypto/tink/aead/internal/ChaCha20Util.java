package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.apache.commons.compress.archivers.tar.TarConstants;

final class ChaCha20Util {
    static final int BLOCK_SIZE_IN_BYTES = 64;
    static final int BLOCK_SIZE_IN_INTS = 16;
    static final int KEY_SIZE_IN_BYTES = 32;
    static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 112, 97, 110, 100, 32, TarConstants.LF_CHR, TarConstants.LF_SYMLINK, 45, 98, 121, 116, 101, 32, 107});

    private ChaCha20Util() {
    }

    public static void quarterRound(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = iArr[i11] + iArr[i12];
        iArr[i11] = i15;
        int rotateLeft = rotateLeft(i15 ^ iArr[i14], 16);
        iArr[i14] = rotateLeft;
        int i16 = iArr[i13] + rotateLeft;
        iArr[i13] = i16;
        int rotateLeft2 = rotateLeft(iArr[i12] ^ i16, 12);
        iArr[i12] = rotateLeft2;
        int i17 = iArr[i11] + rotateLeft2;
        iArr[i11] = i17;
        int rotateLeft3 = rotateLeft(iArr[i14] ^ i17, 8);
        iArr[i14] = rotateLeft3;
        int i18 = iArr[i13] + rotateLeft3;
        iArr[i13] = i18;
        iArr[i12] = rotateLeft(iArr[i12] ^ i18, 7);
    }

    private static int rotateLeft(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    public static void setSigmaAndKey(int[] iArr, int[] iArr2) {
        int[] iArr3 = SIGMA;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void shuffleState(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i11 = 0; i11 < 10; i11++) {
            quarterRound(iArr2, 0, 4, 8, 12);
            quarterRound(iArr2, 1, 5, 9, 13);
            quarterRound(iArr2, 2, 6, 10, 14);
            quarterRound(iArr2, 3, 7, 11, 15);
            quarterRound(iArr2, 0, 5, 10, 15);
            quarterRound(iArr2, 1, 6, 11, 12);
            quarterRound(iArr2, 2, 7, 8, 13);
            quarterRound(iArr2, 3, 4, 9, 14);
        }
    }

    public static int[] toIntArray(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
