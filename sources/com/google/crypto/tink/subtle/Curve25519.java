package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;
import com.google.crypto.tink.annotations.Alpha;
import java.security.InvalidKeyException;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Alpha
final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, Ascii.SYN, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, TarConstants.LF_SYMLINK, -79, -3, -122, 98, 5, Ascii.SYN, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, TarConstants.LF_PAX_EXTENDED_HEADER_UC, Ascii.FS, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    private Curve25519() {
    }

    public static void copyConditional(long[] jArr, long[] jArr2, int i11) {
        int i12 = -i11;
        for (int i13 = 0; i13 < 10; i13++) {
            long j11 = jArr[i13];
            jArr[i13] = (long) (((int) j11) ^ ((((int) j11) ^ ((int) jArr2[i13])) & i12));
        }
    }

    public static void curveMult(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        long[] jArr2 = jArr;
        long[] expand = Field25519.expand(validatePubKeyAndClearMsb(bArr2));
        long[] jArr3 = new long[19];
        long[] jArr4 = new long[19];
        int i11 = 0;
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        jArr5[0] = 1;
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        long[] jArr8 = new long[19];
        jArr8[0] = 1;
        long[] jArr9 = new long[19];
        long[] jArr10 = new long[19];
        jArr10[0] = 1;
        int i12 = 10;
        System.arraycopy(expand, 0, jArr3, 0, 10);
        int i13 = 0;
        while (i13 < 32) {
            byte b11 = bArr[(32 - i13) - 1] & 255;
            long[] jArr11 = jArr7;
            long[] jArr12 = jArr9;
            long[] jArr13 = jArr10;
            long[] jArr14 = jArr4;
            long[] jArr15 = jArr8;
            long[] jArr16 = jArr3;
            int i14 = i11;
            long[] jArr17 = jArr6;
            long[] jArr18 = jArr5;
            long[] jArr19 = jArr17;
            while (i14 < 8) {
                int i15 = (b11 >> (7 - i14)) & 1;
                swapConditional(jArr18, jArr16, i15);
                swapConditional(jArr19, jArr14, i15);
                int i16 = i15;
                long[] jArr20 = jArr15;
                long[] jArr21 = jArr12;
                byte b12 = b11;
                long[] jArr22 = jArr11;
                long[] jArr23 = jArr19;
                long[] jArr24 = jArr18;
                long[] jArr25 = jArr14;
                long[] jArr26 = jArr16;
                monty(jArr12, jArr13, jArr11, jArr20, jArr18, jArr19, jArr16, jArr14, expand);
                swapConditional(jArr21, jArr22, i16);
                long[] jArr27 = jArr20;
                swapConditional(jArr13, jArr27, i16);
                i14++;
                jArr14 = jArr27;
                jArr19 = jArr13;
                jArr18 = jArr21;
                jArr16 = jArr22;
                b11 = b12;
                jArr13 = jArr23;
                jArr12 = jArr24;
                jArr15 = jArr25;
                jArr11 = jArr26;
            }
            long[] jArr28 = jArr18;
            long[] jArr29 = jArr14;
            long[] jArr30 = jArr16;
            jArr8 = jArr15;
            i13++;
            jArr10 = jArr13;
            jArr9 = jArr12;
            jArr7 = jArr11;
            jArr6 = jArr19;
            jArr5 = jArr28;
            jArr4 = jArr29;
            jArr3 = jArr30;
            i11 = 0;
            i12 = 10;
        }
        long[] jArr31 = new long[i12];
        Field25519.inverse(jArr31, jArr6);
        Field25519.mult(jArr2, jArr5, jArr31);
        if (!isCollinear(expand, jArr2, jArr3, jArr4)) {
            throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + Hex.encode(bArr2));
        }
    }

    private static boolean isCollinear(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[11];
        long[] jArr8 = new long[11];
        long[] jArr9 = new long[11];
        Field25519.mult(jArr5, jArr, jArr2);
        Field25519.sum(jArr6, jArr, jArr2);
        long[] jArr10 = new long[10];
        jArr10[0] = 486662;
        Field25519.sum(jArr8, jArr6, jArr10);
        Field25519.mult(jArr8, jArr8, jArr4);
        Field25519.sum(jArr8, jArr3);
        Field25519.mult(jArr8, jArr8, jArr5);
        Field25519.mult(jArr8, jArr8, jArr3);
        Field25519.scalarProduct(jArr7, jArr8, 4);
        Field25519.reduceCoefficients(jArr7);
        Field25519.mult(jArr8, jArr5, jArr4);
        Field25519.sub(jArr8, jArr8, jArr4);
        Field25519.mult(jArr9, jArr6, jArr3);
        Field25519.sum(jArr8, jArr8, jArr9);
        Field25519.square(jArr8, jArr8);
        return Bytes.equal(Field25519.contract(jArr7), Field25519.contract(jArr8));
    }

    private static void monty(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5, long[] jArr6, long[] jArr7, long[] jArr8, long[] jArr9) {
        long[] jArr10 = jArr5;
        long[] jArr11 = jArr6;
        long[] jArr12 = jArr7;
        long[] jArr13 = jArr8;
        long[] copyOf = Arrays.copyOf(jArr10, 10);
        long[] jArr14 = new long[19];
        long[] jArr15 = new long[19];
        long[] jArr16 = new long[19];
        long[] jArr17 = new long[19];
        long[] jArr18 = new long[19];
        long[] jArr19 = new long[19];
        long[] jArr20 = new long[19];
        Field25519.sum(jArr5, jArr6);
        Field25519.sub(jArr11, copyOf);
        long[] copyOf2 = Arrays.copyOf(jArr12, 10);
        Field25519.sum(jArr7, jArr8);
        Field25519.sub(jArr13, copyOf2);
        Field25519.product(jArr17, jArr12, jArr11);
        Field25519.product(jArr18, jArr10, jArr13);
        Field25519.reduceSizeByModularReduction(jArr17);
        Field25519.reduceCoefficients(jArr17);
        Field25519.reduceSizeByModularReduction(jArr18);
        Field25519.reduceCoefficients(jArr18);
        System.arraycopy(jArr17, 0, copyOf2, 0, 10);
        Field25519.sum(jArr17, jArr18);
        Field25519.sub(jArr18, copyOf2);
        Field25519.square(jArr20, jArr17);
        Field25519.square(jArr19, jArr18);
        Field25519.product(jArr18, jArr19, jArr9);
        Field25519.reduceSizeByModularReduction(jArr18);
        Field25519.reduceCoefficients(jArr18);
        long[] jArr21 = jArr3;
        System.arraycopy(jArr20, 0, jArr3, 0, 10);
        System.arraycopy(jArr18, 0, jArr4, 0, 10);
        Field25519.square(jArr15, jArr10);
        Field25519.square(jArr16, jArr11);
        long[] jArr22 = jArr;
        Field25519.product(jArr, jArr15, jArr16);
        Field25519.reduceSizeByModularReduction(jArr);
        Field25519.reduceCoefficients(jArr);
        Field25519.sub(jArr16, jArr15);
        Arrays.fill(jArr14, 10, 18, 0);
        Field25519.scalarProduct(jArr14, jArr16, 121665);
        Field25519.reduceCoefficients(jArr14);
        Field25519.sum(jArr14, jArr15);
        long[] jArr23 = jArr2;
        Field25519.product(jArr2, jArr16, jArr14);
        Field25519.reduceSizeByModularReduction(jArr2);
        Field25519.reduceCoefficients(jArr2);
    }

    public static void swapConditional(long[] jArr, long[] jArr2, int i11) {
        int i12 = -i11;
        for (int i13 = 0; i13 < 10; i13++) {
            long j11 = jArr[i13];
            int i14 = (((int) j11) ^ ((int) jArr2[i13])) & i12;
            jArr[i13] = (long) (((int) j11) ^ i14);
            jArr2[i13] = (long) (((int) jArr2[i13]) ^ i14);
        }
    }

    private static byte[] validatePubKeyAndClearMsb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i11 = 0;
            while (true) {
                byte[][] bArr2 = BANNED_PUBLIC_KEYS;
                if (i11 >= bArr2.length) {
                    return copyOf;
                }
                if (!Bytes.equal(bArr2[i11], copyOf)) {
                    i11++;
                } else {
                    throw new InvalidKeyException("Banned public key: " + Hex.encode(bArr2[i11]));
                }
            }
        } else {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
    }
}
