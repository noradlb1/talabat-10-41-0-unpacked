package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjz  reason: invalid package */
public final class zzjz {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zzc(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r56v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zzb(long[] r56, long[] r57, long[] r58) {
        /*
            r0 = 0
            r1 = r57[r0]
            r3 = r58[r0]
            long r1 = r1 * r3
            r56[r0] = r1
            r1 = r57[r0]
            r3 = 1
            r4 = r58[r3]
            long r4 = r4 * r1
            r6 = r57[r3]
            r8 = r58[r0]
            long r6 = r6 * r8
            long r4 = r4 + r6
            r56[r3] = r4
            r4 = r57[r3]
            long r6 = r4 + r4
            r10 = r58[r3]
            long r6 = r6 * r10
            r0 = 2
            r12 = r58[r0]
            long r12 = r12 * r1
            r14 = r57[r0]
            long r14 = r14 * r8
            long r6 = r6 + r12
            long r6 = r6 + r14
            r56[r0] = r6
            r6 = r58[r0]
            long r12 = r4 * r6
            r14 = r57[r0]
            long r16 = r14 * r10
            r0 = 3
            r18 = r58[r0]
            long r18 = r18 * r1
            r20 = r57[r0]
            long r20 = r20 * r8
            long r12 = r12 + r16
            long r12 = r12 + r18
            long r12 = r12 + r20
            r56[r0] = r12
            long r12 = r14 * r6
            r16 = r58[r0]
            long r18 = r4 * r16
            r20 = r57[r0]
            long r22 = r20 * r10
            r0 = 4
            r24 = r58[r0]
            long r24 = r24 * r1
            r26 = r57[r0]
            long r26 = r26 * r8
            long r18 = r18 + r22
            long r18 = r18 + r18
            long r12 = r12 + r18
            long r12 = r12 + r24
            long r12 = r12 + r26
            r56[r0] = r12
            long r12 = r14 * r16
            long r18 = r20 * r6
            r22 = r58[r0]
            long r24 = r4 * r22
            r26 = r57[r0]
            long r28 = r26 * r10
            r0 = 5
            r30 = r58[r0]
            long r30 = r30 * r1
            r32 = r57[r0]
            long r32 = r32 * r8
            long r12 = r12 + r18
            long r12 = r12 + r24
            long r12 = r12 + r28
            long r12 = r12 + r30
            long r12 = r12 + r32
            r56[r0] = r12
            long r12 = r20 * r16
            r18 = r58[r0]
            long r24 = r4 * r18
            r28 = r57[r0]
            long r30 = r28 * r10
            long r32 = r14 * r22
            long r34 = r26 * r6
            r0 = 6
            r36 = r58[r0]
            long r36 = r36 * r1
            r38 = r57[r0]
            long r38 = r38 * r8
            long r12 = r12 + r24
            long r12 = r12 + r30
            long r12 = r12 + r12
            long r12 = r12 + r32
            long r12 = r12 + r34
            long r12 = r12 + r36
            long r12 = r12 + r38
            r56[r0] = r12
            long r12 = r20 * r22
            long r24 = r26 * r16
            long r30 = r14 * r18
            long r32 = r28 * r6
            r34 = r58[r0]
            long r36 = r4 * r34
            r38 = r57[r0]
            long r40 = r38 * r10
            r0 = 7
            r42 = r58[r0]
            long r42 = r42 * r1
            r44 = r57[r0]
            long r44 = r44 * r8
            long r12 = r12 + r24
            long r12 = r12 + r30
            long r12 = r12 + r32
            long r12 = r12 + r36
            long r12 = r12 + r40
            long r12 = r12 + r42
            long r12 = r12 + r44
            r56[r0] = r12
            long r12 = r26 * r22
            long r24 = r20 * r18
            long r30 = r28 * r16
            r32 = r58[r0]
            long r36 = r4 * r32
            r40 = r57[r0]
            long r42 = r40 * r10
            long r44 = r14 * r34
            long r46 = r38 * r6
            r0 = 8
            r48 = r58[r0]
            long r48 = r48 * r1
            r50 = r57[r0]
            long r50 = r50 * r8
            long r24 = r24 + r30
            long r24 = r24 + r36
            long r24 = r24 + r42
            long r24 = r24 + r24
            long r12 = r12 + r24
            long r12 = r12 + r44
            long r12 = r12 + r46
            long r12 = r12 + r48
            long r12 = r12 + r50
            r56[r0] = r12
            long r12 = r26 * r18
            long r24 = r28 * r22
            long r30 = r20 * r34
            long r36 = r38 * r16
            long r42 = r14 * r32
            long r44 = r40 * r6
            r46 = r58[r0]
            long r48 = r4 * r46
            r50 = r57[r0]
            long r52 = r50 * r10
            r0 = 9
            r54 = r58[r0]
            long r1 = r1 * r54
            r54 = r57[r0]
            long r54 = r54 * r8
            long r12 = r12 + r24
            long r12 = r12 + r30
            long r12 = r12 + r36
            long r12 = r12 + r42
            long r12 = r12 + r44
            long r12 = r12 + r48
            long r12 = r12 + r52
            long r12 = r12 + r1
            long r12 = r12 + r54
            r56[r0] = r12
            long r1 = r28 * r18
            long r8 = r20 * r32
            long r12 = r40 * r16
            r24 = r58[r0]
            long r4 = r4 * r24
            r30 = r57[r0]
            long r10 = r10 * r30
            long r36 = r26 * r34
            long r42 = r38 * r22
            long r44 = r14 * r46
            long r48 = r50 * r6
            long r1 = r1 + r8
            long r1 = r1 + r12
            long r1 = r1 + r4
            long r1 = r1 + r10
            long r1 = r1 + r1
            long r1 = r1 + r36
            long r1 = r1 + r42
            long r1 = r1 + r44
            long r1 = r1 + r48
            r0 = 10
            r56[r0] = r1
            long r0 = r28 * r34
            long r2 = r38 * r18
            long r4 = r26 * r32
            long r8 = r40 * r22
            long r10 = r20 * r46
            long r12 = r50 * r16
            long r14 = r14 * r24
            long r6 = r6 * r30
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r8
            long r0 = r0 + r10
            long r0 = r0 + r12
            long r0 = r0 + r14
            long r0 = r0 + r6
            r2 = 11
            r56[r2] = r0
            long r0 = r38 * r34
            long r2 = r28 * r32
            long r4 = r40 * r18
            long r20 = r20 * r24
            long r16 = r16 * r30
            long r6 = r26 * r46
            long r8 = r50 * r22
            long r2 = r2 + r4
            long r2 = r2 + r20
            long r2 = r2 + r16
            long r2 = r2 + r2
            long r0 = r0 + r2
            long r0 = r0 + r6
            long r0 = r0 + r8
            r2 = 12
            r56[r2] = r0
            long r0 = r38 * r32
            long r2 = r40 * r34
            long r4 = r28 * r46
            long r6 = r50 * r18
            long r26 = r26 * r24
            long r22 = r22 * r30
            long r0 = r0 + r2
            long r0 = r0 + r4
            long r0 = r0 + r6
            long r0 = r0 + r26
            long r0 = r0 + r22
            r2 = 13
            r56[r2] = r0
            long r0 = r40 * r32
            long r28 = r28 * r24
            long r18 = r18 * r30
            long r2 = r38 * r46
            long r4 = r50 * r34
            long r0 = r0 + r28
            long r0 = r0 + r18
            long r0 = r0 + r0
            long r0 = r0 + r2
            long r0 = r0 + r4
            r2 = 14
            r56[r2] = r0
            long r0 = r40 * r46
            long r2 = r50 * r32
            long r38 = r38 * r24
            long r34 = r34 * r30
            long r0 = r0 + r2
            long r0 = r0 + r38
            long r0 = r0 + r34
            r2 = 15
            r56[r2] = r0
            long r0 = r50 * r46
            long r40 = r40 * r24
            long r32 = r32 * r30
            long r40 = r40 + r32
            long r40 = r40 + r40
            long r0 = r0 + r40
            r2 = 16
            r56[r2] = r0
            long r50 = r50 * r24
            long r46 = r46 * r30
            long r50 = r50 + r46
            r0 = 17
            r56[r0] = r50
            long r30 = r30 + r30
            long r30 = r30 * r24
            r0 = 18
            r56[r0] = r30
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzjz.zzb(long[], long[], long[]):void");
    }

    public static void zzc(long[] jArr, long[] jArr2) {
        zze(jArr);
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i11 = 0;
        while (i11 < 10) {
            long j11 = jArr[i11];
            long j12 = j11 / 67108864;
            jArr[i11] = j11 - (j12 << 26);
            int i12 = i11 + 1;
            long j13 = jArr[i12] + j12;
            jArr[i12] = j13;
            long j14 = j13 / 33554432;
            jArr[i12] = j13 - (j14 << 25);
            i11 += 2;
            jArr[i11] = jArr[i11] + j14;
        }
        long j15 = jArr[0];
        long j16 = jArr[10];
        long j17 = j15 + (j16 << 4);
        jArr[0] = j17;
        long j18 = j17 + j16 + j16;
        jArr[0] = j18;
        long j19 = j18 + j16;
        jArr[0] = j19;
        jArr[10] = 0;
        long j21 = j19 / 67108864;
        jArr[0] = j19 - (j21 << 26);
        jArr[1] = jArr[1] + j21;
    }

    public static void zze(long[] jArr) {
        long j11 = jArr[8];
        long j12 = jArr[18];
        long j13 = j11 + (j12 << 4);
        jArr[8] = j13;
        long j14 = j13 + j12 + j12;
        jArr[8] = j14;
        jArr[8] = j14 + j12;
        long j15 = jArr[7];
        long j16 = jArr[17];
        long j17 = j15 + (j16 << 4);
        jArr[7] = j17;
        long j18 = j17 + j16 + j16;
        jArr[7] = j18;
        jArr[7] = j18 + j16;
        long j19 = jArr[6];
        long j21 = jArr[16];
        long j22 = j19 + (j21 << 4);
        jArr[6] = j22;
        long j23 = j22 + j21 + j21;
        jArr[6] = j23;
        jArr[6] = j23 + j21;
        long j24 = jArr[5];
        long j25 = jArr[15];
        long j26 = j24 + (j25 << 4);
        jArr[5] = j26;
        long j27 = j26 + j25 + j25;
        jArr[5] = j27;
        jArr[5] = j27 + j25;
        long j28 = jArr[4];
        long j29 = jArr[14];
        long j31 = j28 + (j29 << 4);
        jArr[4] = j31;
        long j32 = j31 + j29 + j29;
        jArr[4] = j32;
        jArr[4] = j32 + j29;
        long j33 = jArr[3];
        long j34 = jArr[13];
        long j35 = j33 + (j34 << 4);
        jArr[3] = j35;
        long j36 = j35 + j34 + j34;
        jArr[3] = j36;
        jArr[3] = j36 + j34;
        long j37 = jArr[2];
        long j38 = jArr[12];
        long j39 = j37 + (j38 << 4);
        jArr[2] = j39;
        long j41 = j39 + j38 + j38;
        jArr[2] = j41;
        jArr[2] = j41 + j38;
        long j42 = jArr[1];
        long j43 = jArr[11];
        long j44 = j42 + (j43 << 4);
        jArr[1] = j44;
        long j45 = j44 + j43 + j43;
        jArr[1] = j45;
        jArr[1] = j45 + j43;
        long j46 = jArr[0];
        long j47 = jArr[10];
        long j48 = j46 + (j47 << 4);
        jArr[0] = j48;
        long j49 = j48 + j47 + j47;
        jArr[0] = j49;
        jArr[0] = j49 + j47;
    }

    public static void zzf(long[] jArr, long[] jArr2, long j11) {
        for (int i11 = 0; i11 < 10; i11++) {
            jArr[i11] = jArr2[i11] * j11;
        }
    }

    public static void zzg(long[] jArr, long[] jArr2) {
        long j11 = jArr2[0];
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long j14 = (j13 * j13) + (jArr2[2] * j12);
        long j15 = jArr2[2];
        long j16 = (j13 * j15) + (jArr2[3] * j12);
        long j17 = jArr2[3];
        long j18 = (j15 * j15) + (j13 * 4 * j17);
        long j19 = jArr2[4];
        long j21 = (j15 * j17) + (j13 * j19) + (jArr2[5] * j12);
        long j22 = jArr2[5];
        long j23 = (j17 * j17) + (j15 * j19) + (jArr2[6] * j12) + ((j13 + j13) * j22);
        long j24 = jArr2[6];
        long j25 = (j17 * j19) + (j15 * j22) + (j13 * j24) + (jArr2[7] * j12);
        long j26 = jArr2[7];
        long j27 = (j13 * j26) + (j17 * j22);
        long j28 = (j15 * j24) + (jArr2[8] * j12) + j27 + j27;
        long j29 = jArr2[8];
        long j31 = (j19 * j22) + (j17 * j24) + (j15 * j26) + (j13 * j29) + (j12 * jArr2[9]);
        long j32 = jArr2[9];
        long j33 = (j17 * j26) + (j13 * j32);
        long j34 = (j22 * j22) + (j19 * j24) + (j15 * j29) + j33 + j33;
        long j35 = (j22 * j24) + (j19 * j26) + (j17 * j29) + (j15 * j32);
        long j36 = (j22 * j26) + (j17 * j32);
        long j37 = (j19 * j29) + j36 + j36;
        long j38 = (j24 * j26) + (j22 * j29) + (j19 * j32);
        long j39 = (j26 * j26) + (j24 * j29) + ((j22 + j22) * j32);
        long j41 = (j26 * j29) + (j24 * j32);
        zzc(new long[]{j11 * j11, (j12 + j12) * jArr2[1], j14 + j14, j16 + j16, j18 + ((j12 + j12) * jArr2[4]), j21 + j21, j23 + j23, j25 + j25, (j19 * j19) + j28 + j28, j31 + j31, j34 + j34, j35 + j35, (j24 * j24) + j37 + j37, j38 + j38, j39 + j39, j41 + j41, (j29 * j29) + (j26 * 4 * j32), (j29 + j29) * j32, (j32 + j32) * j32}, jArr);
    }

    public static void zzh(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 10; i11++) {
            jArr[i11] = jArr2[i11] - jArr3[i11];
        }
    }

    public static void zzi(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 10; i11++) {
            jArr[i11] = jArr2[i11] + jArr3[i11];
        }
    }

    public static byte[] zzj(long[] jArr) {
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
                int i14 = zzd[i13 & 1];
                int i15 = -((int) (((j11 >> 31) & j11) >> i14));
                copyOf[i13] = j11 + ((long) (i15 << i14));
                i13++;
                copyOf[i13] = copyOf[i13] - ((long) i15);
            }
            long j12 = copyOf[9];
            int i16 = -((int) (((j12 >> 31) & j12) >> 25));
            copyOf[9] = j12 + ((long) (i16 << 25));
            copyOf[0] = copyOf[0] - (((long) i16) * 19);
            i12++;
        }
        long j13 = copyOf[0];
        int i17 = -((int) (((j13 >> 31) & j13) >> 26));
        copyOf[0] = j13 + ((long) (i17 << 26));
        copyOf[1] = copyOf[1] - ((long) i17);
        int i18 = 0;
        for (i11 = 2; i18 < i11; i11 = 2) {
            int i19 = 0;
            while (i19 < 9) {
                long j14 = copyOf[i19];
                int i21 = i19 & 1;
                long j15 = j14 >> zzd[i21];
                copyOf[i19] = j14 & ((long) zzc[i21]);
                i19++;
                copyOf[i19] = copyOf[i19] + ((long) ((int) j15));
            }
            i18++;
        }
        long j16 = copyOf[9];
        copyOf[9] = j16 & 33554431;
        long j17 = copyOf[0] + (((long) ((int) (j16 >> 25))) * 19);
        copyOf[0] = j17;
        int i22 = ~((((int) j17) - 67108845) >> 31);
        for (int i23 = 1; i23 < 10; i23++) {
            int i24 = ~(((int) copyOf[i23]) ^ zzc[i23 & 1]);
            int i25 = i24 & (i24 << 16);
            int i26 = i25 & (i25 << 8);
            int i27 = i26 & (i26 << 4);
            int i28 = i27 & (i27 << 2);
            i22 &= (i28 & (i28 + i28)) >> 31;
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & i22));
        long j18 = (long) (33554431 & i22);
        copyOf[1] = copyOf[1] - j18;
        for (int i29 = 2; i29 < 10; i29 += 2) {
            copyOf[i29] = copyOf[i29] - ((long) (67108863 & i22));
            int i31 = i29 + 1;
            copyOf[i31] = copyOf[i31] - j18;
        }
        for (int i32 = 0; i32 < 10; i32++) {
            copyOf[i32] = copyOf[i32] << zzb[i32];
        }
        byte[] bArr = new byte[32];
        for (int i33 = 0; i33 < 10; i33++) {
            int i34 = zza[i33];
            long j19 = copyOf[i33];
            bArr[i34] = (byte) ((int) (((long) bArr[i34]) | (j19 & 255)));
            int i35 = i34 + 1;
            bArr[i35] = (byte) ((int) (((long) bArr[i35]) | ((j19 >> 8) & 255)));
            int i36 = i34 + 2;
            bArr[i36] = (byte) ((int) (((long) bArr[i36]) | ((j19 >> 16) & 255)));
            int i37 = i34 + 3;
            bArr[i37] = (byte) ((int) (((long) bArr[i37]) | ((j19 >> 24) & 255)));
        }
        return bArr;
    }

    public static long[] zzk(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i11 = 0; i11 < 10; i11++) {
            int i12 = zza[i11];
            jArr[i11] = ((((((long) (bArr[i12] & 255)) | (((long) (bArr[i12 + 1] & 255)) << 8)) | (((long) (bArr[i12 + 2] & 255)) << 16)) | (((long) (bArr[i12 + 3] & 255)) << 24)) >> zzb[i11]) & ((long) zzc[i11 & 1]);
        }
        return jArr;
    }
}
