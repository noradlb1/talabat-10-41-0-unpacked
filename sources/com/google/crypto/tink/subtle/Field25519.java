package com.google.crypto.tink.subtle;

import com.google.crypto.tink.annotations.Alpha;
import java.util.Arrays;

@Alpha
final class Field25519 {
    private static final int[] EXPAND_SHIFT = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] EXPAND_START = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    static final int FIELD_LEN = 32;
    static final int LIMB_CNT = 10;
    private static final int[] MASK = {67108863, 33554431};
    private static final int[] SHIFT = {26, 25};
    private static final long TWO_TO_25 = 33554432;
    private static final long TWO_TO_26 = 67108864;

    private Field25519() {
    }

    public static byte[] contract(long[] jArr) {
        int i11;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i12 = 0;
        while (true) {
            if (i12 >= 2) {
                break;
            }
            int i13 = 0;
            while (i13 < 9) {
                long j11 = copyOf[i13];
                int i14 = SHIFT[i13 & 1];
                int i15 = -((int) (((j11 >> 31) & j11) >> i14));
                copyOf[i13] = j11 + ((long) (i15 << i14));
                i13++;
                copyOf[i13] = copyOf[i13] - ((long) i15);
            }
            long j12 = copyOf[9];
            int i16 = -((int) (((j12 >> 31) & j12) >> 25));
            copyOf[9] = j12 + ((long) (i16 << 25));
            copyOf[0] = copyOf[0] - ((long) (i16 * 19));
            i12++;
        }
        long j13 = copyOf[0];
        int i17 = -((int) (((j13 >> 31) & j13) >> 26));
        copyOf[0] = j13 + ((long) (i17 << 26));
        copyOf[1] = copyOf[1] - ((long) i17);
        for (int i18 = 0; i18 < 2; i18++) {
            int i19 = 0;
            while (i19 < 9) {
                long j14 = copyOf[i19];
                int i21 = i19 & 1;
                int i22 = (int) (j14 >> SHIFT[i21]);
                copyOf[i19] = j14 & ((long) MASK[i21]);
                i19++;
                copyOf[i19] = copyOf[i19] + ((long) i22);
            }
        }
        long j15 = copyOf[9];
        copyOf[9] = j15 & 33554431;
        long j16 = copyOf[0] + ((long) (((int) (j15 >> 25)) * 19));
        copyOf[0] = j16;
        int gte = gte((int) j16, 67108845);
        for (int i23 = 1; i23 < 10; i23++) {
            gte &= eq((int) copyOf[i23], MASK[i23 & 1]);
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & gte));
        long j17 = (long) (33554431 & gte);
        copyOf[1] = copyOf[1] - j17;
        for (i11 = 2; i11 < 10; i11 += 2) {
            copyOf[i11] = copyOf[i11] - ((long) (67108863 & gte));
            int i24 = i11 + 1;
            copyOf[i24] = copyOf[i24] - j17;
        }
        for (int i25 = 0; i25 < 10; i25++) {
            copyOf[i25] = copyOf[i25] << EXPAND_SHIFT[i25];
        }
        byte[] bArr = new byte[32];
        for (int i26 = 0; i26 < 10; i26++) {
            int i27 = EXPAND_START[i26];
            long j18 = copyOf[i26];
            bArr[i27] = (byte) ((int) (((long) bArr[i27]) | (j18 & 255)));
            int i28 = i27 + 1;
            bArr[i28] = (byte) ((int) (((long) bArr[i28]) | ((j18 >> 8) & 255)));
            int i29 = i27 + 2;
            bArr[i29] = (byte) ((int) (((long) bArr[i29]) | ((j18 >> 16) & 255)));
            int i31 = i27 + 3;
            bArr[i31] = (byte) ((int) (((long) bArr[i31]) | ((j18 >> 24) & 255)));
        }
        return bArr;
    }

    private static int eq(int i11, int i12) {
        int i13 = ~(i11 ^ i12);
        int i14 = i13 & (i13 << 16);
        int i15 = i14 & (i14 << 8);
        int i16 = i15 & (i15 << 4);
        int i17 = i16 & (i16 << 2);
        return (i17 & (i17 << 1)) >> 31;
    }

    public static long[] expand(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i11 = 0; i11 < 10; i11++) {
            int i12 = EXPAND_START[i11];
            jArr[i11] = ((((((long) (bArr[i12] & 255)) | (((long) (bArr[i12 + 1] & 255)) << 8)) | (((long) (bArr[i12 + 2] & 255)) << 16)) | (((long) (bArr[i12 + 3] & 255)) << 24)) >> EXPAND_SHIFT[i11]) & ((long) MASK[i11 & 1]);
        }
        return jArr;
    }

    private static int gte(int i11, int i12) {
        return ~((i11 - i12) >> 31);
    }

    public static void inverse(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        square(jArr3, jArr2);
        square(jArr12, jArr3);
        square(jArr11, jArr12);
        mult(jArr4, jArr11, jArr2);
        mult(jArr5, jArr4, jArr3);
        square(jArr11, jArr5);
        mult(jArr6, jArr11, jArr4);
        square(jArr11, jArr6);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        mult(jArr7, jArr11, jArr6);
        square(jArr11, jArr7);
        square(jArr12, jArr11);
        for (int i11 = 2; i11 < 10; i11 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr8, jArr12, jArr7);
        square(jArr11, jArr8);
        square(jArr12, jArr11);
        for (int i12 = 2; i12 < 20; i12 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr8);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        for (int i13 = 2; i13 < 10; i13 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr9, jArr11, jArr7);
        square(jArr11, jArr9);
        square(jArr12, jArr11);
        for (int i14 = 2; i14 < 50; i14 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr10, jArr12, jArr9);
        square(jArr12, jArr10);
        square(jArr11, jArr12);
        for (int i15 = 2; i15 < 100; i15 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr12, jArr11, jArr10);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        for (int i16 = 2; i16 < 50; i16 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr9);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        mult(jArr, jArr12, jArr5);
    }

    public static void mult(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        product(jArr4, jArr2, jArr3);
        reduce(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r44v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void product(long[] r44, long[] r45, long[] r46) {
        /*
            r0 = 0
            r1 = r45[r0]
            r3 = r46[r0]
            long r1 = r1 * r3
            r44[r0] = r1
            r1 = r45[r0]
            r3 = 1
            r4 = r46[r3]
            long r4 = r4 * r1
            r6 = r45[r3]
            r8 = r46[r0]
            long r6 = r6 * r8
            long r4 = r4 + r6
            r44[r3] = r4
            r4 = r45[r3]
            r6 = 2
            long r10 = r4 * r6
            r12 = r46[r3]
            long r10 = r10 * r12
            r0 = 2
            r14 = r46[r0]
            long r14 = r14 * r1
            long r10 = r10 + r14
            r14 = r45[r0]
            long r14 = r14 * r8
            long r10 = r10 + r14
            r44[r0] = r10
            r10 = r46[r0]
            long r14 = r4 * r10
            r16 = r45[r0]
            long r18 = r16 * r12
            long r14 = r14 + r18
            r0 = 3
            r18 = r46[r0]
            long r18 = r18 * r1
            long r14 = r14 + r18
            r18 = r45[r0]
            long r18 = r18 * r8
            long r14 = r14 + r18
            r44[r0] = r14
            long r14 = r16 * r10
            r18 = r46[r0]
            long r20 = r4 * r18
            r22 = r45[r0]
            long r24 = r22 * r12
            long r20 = r20 + r24
            long r20 = r20 * r6
            long r14 = r14 + r20
            r0 = 4
            r20 = r46[r0]
            long r20 = r20 * r1
            long r14 = r14 + r20
            r20 = r45[r0]
            long r20 = r20 * r8
            long r14 = r14 + r20
            r44[r0] = r14
            long r14 = r16 * r18
            long r20 = r22 * r10
            long r14 = r14 + r20
            r20 = r46[r0]
            long r24 = r4 * r20
            long r14 = r14 + r24
            r24 = r45[r0]
            long r26 = r24 * r12
            long r14 = r14 + r26
            r0 = 5
            r26 = r46[r0]
            long r26 = r26 * r1
            long r14 = r14 + r26
            r26 = r45[r0]
            long r26 = r26 * r8
            long r14 = r14 + r26
            r44[r0] = r14
            long r14 = r22 * r18
            r26 = r46[r0]
            long r28 = r4 * r26
            long r14 = r14 + r28
            r28 = r45[r0]
            long r30 = r28 * r12
            long r14 = r14 + r30
            long r14 = r14 * r6
            long r30 = r16 * r20
            long r14 = r14 + r30
            long r30 = r24 * r10
            long r14 = r14 + r30
            r0 = 6
            r30 = r46[r0]
            long r30 = r30 * r1
            long r14 = r14 + r30
            r30 = r45[r0]
            long r30 = r30 * r8
            long r14 = r14 + r30
            r44[r0] = r14
            long r14 = r22 * r20
            long r30 = r24 * r18
            long r14 = r14 + r30
            long r30 = r16 * r26
            long r14 = r14 + r30
            long r30 = r28 * r10
            long r14 = r14 + r30
            r30 = r46[r0]
            long r32 = r4 * r30
            long r14 = r14 + r32
            r32 = r45[r0]
            long r34 = r32 * r12
            long r14 = r14 + r34
            r0 = 7
            r34 = r46[r0]
            long r34 = r34 * r1
            long r14 = r14 + r34
            r34 = r45[r0]
            long r34 = r34 * r8
            long r14 = r14 + r34
            r44[r0] = r14
            long r14 = r24 * r20
            long r34 = r22 * r26
            long r36 = r28 * r18
            long r34 = r34 + r36
            r36 = r46[r0]
            long r38 = r4 * r36
            long r34 = r34 + r38
            r38 = r45[r0]
            long r40 = r38 * r12
            long r34 = r34 + r40
            long r34 = r34 * r6
            long r14 = r14 + r34
            long r34 = r16 * r30
            long r14 = r14 + r34
            long r34 = r32 * r10
            long r14 = r14 + r34
            r0 = 8
            r34 = r46[r0]
            long r34 = r34 * r1
            long r14 = r14 + r34
            r34 = r45[r0]
            long r34 = r34 * r8
            long r14 = r14 + r34
            r44[r0] = r14
            long r14 = r24 * r26
            long r34 = r28 * r20
            long r14 = r14 + r34
            long r34 = r22 * r30
            long r14 = r14 + r34
            long r34 = r32 * r18
            long r14 = r14 + r34
            long r34 = r16 * r36
            long r14 = r14 + r34
            long r34 = r38 * r10
            long r14 = r14 + r34
            r34 = r46[r0]
            long r40 = r4 * r34
            long r14 = r14 + r40
            r40 = r45[r0]
            long r42 = r40 * r12
            long r14 = r14 + r42
            r0 = 9
            r42 = r46[r0]
            long r1 = r1 * r42
            long r14 = r14 + r1
            r1 = r45[r0]
            long r1 = r1 * r8
            long r14 = r14 + r1
            r44[r0] = r14
            long r1 = r28 * r26
            long r8 = r22 * r36
            long r1 = r1 + r8
            long r8 = r38 * r18
            long r1 = r1 + r8
            r8 = r46[r0]
            long r4 = r4 * r8
            long r1 = r1 + r4
            r3 = r45[r0]
            long r12 = r12 * r3
            long r1 = r1 + r12
            long r1 = r1 * r6
            long r12 = r24 * r30
            long r1 = r1 + r12
            long r12 = r32 * r20
            long r1 = r1 + r12
            long r12 = r16 * r34
            long r1 = r1 + r12
            long r12 = r40 * r10
            long r1 = r1 + r12
            r0 = 10
            r44[r0] = r1
            long r0 = r28 * r30
            long r12 = r32 * r26
            long r0 = r0 + r12
            long r12 = r24 * r36
            long r0 = r0 + r12
            long r12 = r38 * r20
            long r0 = r0 + r12
            long r12 = r22 * r34
            long r0 = r0 + r12
            long r12 = r40 * r18
            long r0 = r0 + r12
            long r16 = r16 * r8
            long r0 = r0 + r16
            long r10 = r10 * r3
            long r0 = r0 + r10
            r2 = 11
            r44[r2] = r0
            long r0 = r32 * r30
            long r10 = r28 * r36
            long r12 = r38 * r26
            long r10 = r10 + r12
            long r22 = r22 * r8
            long r10 = r10 + r22
            long r18 = r18 * r3
            long r10 = r10 + r18
            long r10 = r10 * r6
            long r0 = r0 + r10
            long r10 = r24 * r34
            long r0 = r0 + r10
            long r10 = r40 * r20
            long r0 = r0 + r10
            r2 = 12
            r44[r2] = r0
            long r0 = r32 * r36
            long r10 = r38 * r30
            long r0 = r0 + r10
            long r10 = r28 * r34
            long r0 = r0 + r10
            long r10 = r40 * r26
            long r0 = r0 + r10
            long r24 = r24 * r8
            long r0 = r0 + r24
            long r20 = r20 * r3
            long r0 = r0 + r20
            r2 = 13
            r44[r2] = r0
            long r0 = r38 * r36
            long r28 = r28 * r8
            long r0 = r0 + r28
            long r26 = r26 * r3
            long r0 = r0 + r26
            long r0 = r0 * r6
            long r10 = r32 * r34
            long r0 = r0 + r10
            long r10 = r40 * r30
            long r0 = r0 + r10
            r2 = 14
            r44[r2] = r0
            long r0 = r38 * r34
            long r10 = r40 * r36
            long r0 = r0 + r10
            long r32 = r32 * r8
            long r0 = r0 + r32
            long r30 = r30 * r3
            long r0 = r0 + r30
            r2 = 15
            r44[r2] = r0
            long r0 = r40 * r34
            long r38 = r38 * r8
            long r36 = r36 * r3
            long r38 = r38 + r36
            long r38 = r38 * r6
            long r0 = r0 + r38
            r2 = 16
            r44[r2] = r0
            long r40 = r40 * r8
            long r34 = r34 * r3
            long r40 = r40 + r34
            r0 = 17
            r44[r0] = r40
            long r3 = r3 * r6
            long r3 = r3 * r8
            r0 = 18
            r44[r0] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Field25519.product(long[], long[], long[]):void");
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        reduceSizeByModularReduction(jArr);
        reduceCoefficients(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void reduceCoefficients(long[] jArr) {
        jArr[10] = 0;
        int i11 = 0;
        while (i11 < 10) {
            long j11 = jArr[i11];
            long j12 = j11 / TWO_TO_26;
            jArr[i11] = j11 - (j12 << 26);
            int i12 = i11 + 1;
            long j13 = jArr[i12] + j12;
            jArr[i12] = j13;
            long j14 = j13 / TWO_TO_25;
            jArr[i12] = j13 - (j14 << 25);
            i11 += 2;
            jArr[i11] = jArr[i11] + j14;
        }
        long j15 = jArr[0];
        long j16 = jArr[10];
        long j17 = j15 + (j16 << 4);
        jArr[0] = j17;
        long j18 = j17 + (j16 << 1);
        jArr[0] = j18;
        long j19 = j18 + j16;
        jArr[0] = j19;
        jArr[10] = 0;
        long j21 = j19 / TWO_TO_26;
        jArr[0] = j19 - (j21 << 26);
        jArr[1] = jArr[1] + j21;
    }

    public static void reduceSizeByModularReduction(long[] jArr) {
        long j11 = jArr[8];
        long j12 = jArr[18];
        long j13 = j11 + (j12 << 4);
        jArr[8] = j13;
        long j14 = j13 + (j12 << 1);
        jArr[8] = j14;
        jArr[8] = j14 + j12;
        long j15 = jArr[7];
        long j16 = jArr[17];
        long j17 = j15 + (j16 << 4);
        jArr[7] = j17;
        long j18 = j17 + (j16 << 1);
        jArr[7] = j18;
        jArr[7] = j18 + j16;
        long j19 = jArr[6];
        long j21 = jArr[16];
        long j22 = j19 + (j21 << 4);
        jArr[6] = j22;
        long j23 = j22 + (j21 << 1);
        jArr[6] = j23;
        jArr[6] = j23 + j21;
        long j24 = jArr[5];
        long j25 = jArr[15];
        long j26 = j24 + (j25 << 4);
        jArr[5] = j26;
        long j27 = j26 + (j25 << 1);
        jArr[5] = j27;
        jArr[5] = j27 + j25;
        long j28 = jArr[4];
        long j29 = jArr[14];
        long j31 = j28 + (j29 << 4);
        jArr[4] = j31;
        long j32 = j31 + (j29 << 1);
        jArr[4] = j32;
        jArr[4] = j32 + j29;
        long j33 = jArr[3];
        long j34 = jArr[13];
        long j35 = j33 + (j34 << 4);
        jArr[3] = j35;
        long j36 = j35 + (j34 << 1);
        jArr[3] = j36;
        jArr[3] = j36 + j34;
        long j37 = jArr[2];
        long j38 = jArr[12];
        long j39 = j37 + (j38 << 4);
        jArr[2] = j39;
        long j41 = j39 + (j38 << 1);
        jArr[2] = j41;
        jArr[2] = j41 + j38;
        long j42 = jArr[1];
        long j43 = jArr[11];
        long j44 = j42 + (j43 << 4);
        jArr[1] = j44;
        long j45 = j44 + (j43 << 1);
        jArr[1] = j45;
        jArr[1] = j45 + j43;
        long j46 = jArr[0];
        long j47 = jArr[10];
        long j48 = j46 + (j47 << 4);
        jArr[0] = j48;
        long j49 = j48 + (j47 << 1);
        jArr[0] = j49;
        jArr[0] = j49 + j47;
    }

    public static void scalarProduct(long[] jArr, long[] jArr2, long j11) {
        for (int i11 = 0; i11 < 10; i11++) {
            jArr[i11] = jArr2[i11] * j11;
        }
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        squareInner(jArr3, jArr2);
        reduce(jArr3, jArr);
    }

    private static void squareInner(long[] jArr, long[] jArr2) {
        long j11 = jArr2[0];
        jArr[0] = j11 * j11;
        long j12 = jArr2[0];
        jArr[1] = j12 * 2 * jArr2[1];
        long j13 = jArr2[1];
        jArr[2] = ((j13 * j13) + (jArr2[2] * j12)) * 2;
        long j14 = jArr2[2];
        jArr[3] = ((j13 * j14) + (jArr2[3] * j12)) * 2;
        long j15 = jArr2[3];
        jArr[4] = (j14 * j14) + (j13 * 4 * j15) + (j12 * 2 * jArr2[4]);
        long j16 = jArr2[4];
        jArr[5] = ((j14 * j15) + (j13 * j16) + (jArr2[5] * j12)) * 2;
        long j17 = jArr2[5];
        jArr[6] = ((j15 * j15) + (j14 * j16) + (jArr2[6] * j12) + (j13 * 2 * j17)) * 2;
        long j18 = jArr2[6];
        jArr[7] = ((j15 * j16) + (j14 * j17) + (j13 * j18) + (jArr2[7] * j12)) * 2;
        long j19 = (j14 * j18) + (jArr2[8] * j12);
        long j21 = jArr2[7];
        jArr[8] = (j16 * j16) + ((j19 + (((j13 * j21) + (j15 * j17)) * 2)) * 2);
        long j22 = jArr2[8];
        jArr[9] = ((j16 * j17) + (j15 * j18) + (j14 * j21) + (j13 * j22) + (j12 * jArr2[9])) * 2;
        long j23 = jArr2[9];
        jArr[10] = ((j17 * j17) + (j16 * j18) + (j14 * j22) + (((j15 * j21) + (j13 * j23)) * 2)) * 2;
        jArr[11] = ((j17 * j18) + (j16 * j21) + (j15 * j22) + (j14 * j23)) * 2;
        jArr[12] = (j18 * j18) + (((j16 * j22) + (((j17 * j21) + (j15 * j23)) * 2)) * 2);
        jArr[13] = ((j18 * j21) + (j17 * j22) + (j16 * j23)) * 2;
        jArr[14] = ((j21 * j21) + (j18 * j22) + (j17 * 2 * j23)) * 2;
        jArr[15] = ((j21 * j22) + (j18 * j23)) * 2;
        jArr[16] = (j22 * j22) + (j21 * 4 * j23);
        jArr[17] = j22 * 2 * j23;
        jArr[18] = 2 * j23 * j23;
    }

    public static void sub(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 10; i11++) {
            jArr[i11] = jArr2[i11] - jArr3[i11];
        }
    }

    public static void sum(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 10; i11++) {
            jArr[i11] = jArr2[i11] + jArr3[i11];
        }
    }

    public static void sub(long[] jArr, long[] jArr2) {
        sub(jArr, jArr2, jArr);
    }

    public static void sum(long[] jArr, long[] jArr2) {
        sum(jArr, jArr, jArr2);
    }
}
