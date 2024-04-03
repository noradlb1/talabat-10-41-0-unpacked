package com.google.crypto.tink.aead.internal;

import com.google.common.base.Ascii;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    public static byte[] computeMac(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            int i11 = 0;
            long load26 = load26(bArr3, 0, 0) & 67108863;
            int i12 = 3;
            long load262 = load26(bArr3, 3, 2) & 67108611;
            long load263 = load26(bArr3, 6, 4) & 67092735;
            long load264 = load26(bArr3, 9, 6) & 66076671;
            long load265 = load26(bArr3, 12, 8) & 1048575;
            long j11 = load262 * 5;
            long j12 = load263 * 5;
            long j13 = load264 * 5;
            long j14 = load265 * 5;
            byte[] bArr5 = new byte[17];
            long j15 = 0;
            int i13 = 0;
            long j16 = 0;
            long j17 = 0;
            long j18 = 0;
            long j19 = 0;
            while (i13 < bArr4.length) {
                copyBlockSize(bArr5, bArr4, i13);
                long load266 = j19 + load26(bArr5, i11, i11);
                long load267 = j15 + load26(bArr5, i12, 2);
                long load268 = j16 + load26(bArr5, 6, 4);
                long load269 = j17 + load26(bArr5, 9, 6);
                long load2610 = j18 + (load26(bArr5, 12, 8) | ((long) (bArr5[16] << Ascii.CAN)));
                long j21 = (load266 * load26) + (load267 * j14) + (load268 * j13) + (load269 * j12) + (load2610 * j11);
                long j22 = (load266 * load262) + (load267 * load26) + (load268 * j14) + (load269 * j13) + (load2610 * j12) + (j21 >> 26);
                long j23 = (load266 * load263) + (load267 * load262) + (load268 * load26) + (load269 * j14) + (load2610 * j13) + (j22 >> 26);
                long j24 = (load266 * load264) + (load267 * load263) + (load268 * load262) + (load269 * load26) + (load2610 * j14) + (j23 >> 26);
                long j25 = (load266 * load265) + (load267 * load264) + (load268 * load263) + (load269 * load262) + (load2610 * load26) + (j24 >> 26);
                long j26 = (j21 & 67108863) + ((j25 >> 26) * 5);
                j15 = (j22 & 67108863) + (j26 >> 26);
                i13 += 16;
                j16 = j23 & 67108863;
                j17 = j24 & 67108863;
                j18 = j25 & 67108863;
                i12 = 3;
                j19 = j26 & 67108863;
                i11 = 0;
            }
            long j27 = j16 + (j15 >> 26);
            long j28 = j27 & 67108863;
            long j29 = j17 + (j27 >> 26);
            long j31 = j29 & 67108863;
            long j32 = j18 + (j29 >> 26);
            long j33 = j32 & 67108863;
            long j34 = j19 + ((j32 >> 26) * 5);
            long j35 = j34 & 67108863;
            long j36 = (j15 & 67108863) + (j34 >> 26);
            long j37 = j35 + 5;
            long j38 = j37 & 67108863;
            long j39 = (j37 >> 26) + j36;
            long j41 = j28 + (j39 >> 26);
            long j42 = j31 + (j41 >> 26);
            long j43 = (j33 + (j42 >> 26)) - 67108864;
            long j44 = j43 >> 63;
            long j45 = j35 & j44;
            long j46 = j36 & j44;
            long j47 = j28 & j44;
            long j48 = j31 & j44;
            long j49 = j33 & j44;
            long j50 = ~j44;
            long j51 = (j39 & 67108863 & j50) | j46;
            long j52 = (j41 & 67108863 & j50) | j47;
            long j53 = (j42 & 67108863 & j50) | j48;
            long load32 = ((j45 | (j38 & j50) | (j51 << 26)) & 4294967295L) + load32(bArr3, 16);
            long j54 = load32 & 4294967295L;
            long load322 = (((j51 >> 6) | (j52 << 20)) & 4294967295L) + load32(bArr3, 20) + (load32 >> 32);
            long load323 = (((j52 >> 12) | (j53 << 14)) & 4294967295L) + load32(bArr3, 24) + (load322 >> 32);
            byte[] bArr6 = new byte[16];
            toByteArray(bArr6, j54, 0);
            toByteArray(bArr6, load322 & 4294967295L, 4);
            toByteArray(bArr6, load323 & 4294967295L, 8);
            toByteArray(bArr6, ((((j53 >> 18) | (((j43 & j50) | j49) << 8)) & 4294967295L) + load32(bArr3, 28) + (load323 >> 32)) & 4294967295L, 12);
            return bArr6;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    private static void copyBlockSize(byte[] bArr, byte[] bArr2, int i11) {
        int min = Math.min(16, bArr2.length - i11);
        System.arraycopy(bArr2, i11, bArr, 0, min);
        bArr[min] = 1;
        if (min != 16) {
            Arrays.fill(bArr, min + 1, bArr.length, (byte) 0);
        }
    }

    private static long load26(byte[] bArr, int i11, int i12) {
        return (load32(bArr, i11) >> i12) & 67108863;
    }

    private static long load32(byte[] bArr, int i11) {
        return ((long) (((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE))) & 4294967295L;
    }

    private static void toByteArray(byte[] bArr, long j11, int i11) {
        int i12 = 0;
        while (i12 < 4) {
            bArr[i11 + i12] = (byte) ((int) (255 & j11));
            i12++;
            j11 >>= 8;
        }
    }

    public static void verifyMac(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
