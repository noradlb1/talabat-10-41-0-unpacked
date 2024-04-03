package com.uxcam.internals;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ba {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f13041a = {new int[]{13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243, 13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243}, new int[]{11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660, 11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660}, new int[]{10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194, 10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194}, new int[]{9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647, 9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647}, new int[]{8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355, 8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355}, new int[]{7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893, 7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893}};

    /* renamed from: b  reason: collision with root package name */
    public static int[] f13042b = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};

    /* renamed from: c  reason: collision with root package name */
    public static int[][] f13043c = {new int[]{10, 13, 10, 13, 13, 16, 13, 16, 10, 13, 10, 13, 13, 16, 13, 16}, new int[]{11, 14, 11, 14, 14, 18, 14, 18, 11, 14, 11, 14, 14, 18, 14, 18}, new int[]{13, 16, 13, 16, 16, 20, 16, 20, 13, 16, 13, 16, 16, 20, 16, 20}, new int[]{14, 18, 14, 18, 18, 23, 18, 23, 14, 18, 14, 18, 18, 23, 18, 23}, new int[]{16, 20, 16, 20, 20, 25, 20, 25, 16, 20, 16, 20, 20, 25, 20, 25}, new int[]{18, 23, 18, 23, 23, 29, 23, 29, 18, 23, 18, 23, 23, 29, 23, 29}};

    /* renamed from: d  reason: collision with root package name */
    public static int[][] f13044d = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 64}));

    /* renamed from: e  reason: collision with root package name */
    public static int[][] f13045e = {new int[]{20, 18, 32, 19, 25, 24}, new int[]{22, 19, 35, 21, 28, 26}, new int[]{26, 23, 42, 24, 33, 31}, new int[]{28, 25, 45, 26, 35, 33}, new int[]{32, 28, 51, 30, 40, 38}, new int[]{36, 32, 58, 34, 46, 43}};

    static {
        for (int i11 = 0; i11 < 6; i11++) {
            Arrays.fill(f13044d[i11], f13045e[i11][5]);
            for (int i12 = 0; i12 < 8; i12 += 4) {
                for (int i13 = 0; i13 < 8; i13 += 4) {
                    f13044d[i11][(i12 << 3) + i13] = f13045e[i11][0];
                }
            }
            for (int i14 = 1; i14 < 8; i14 += 2) {
                for (int i15 = 1; i15 < 8; i15 += 2) {
                    f13044d[i11][(i14 << 3) + i15] = f13045e[i11][1];
                }
            }
            for (int i16 = 2; i16 < 8; i16 += 4) {
                for (int i17 = 2; i17 < 8; i17 += 4) {
                    f13044d[i11][(i16 << 3) + i17] = f13045e[i11][2];
                }
            }
            for (int i18 = 0; i18 < 8; i18 += 4) {
                for (int i19 = 1; i19 < 8; i19 += 2) {
                    f13044d[i11][(i18 << 3) + i19] = f13045e[i11][3];
                }
            }
            for (int i21 = 1; i21 < 8; i21 += 2) {
                for (int i22 = 0; i22 < 8; i22 += 4) {
                    f13044d[i11][(i21 << 3) + i22] = f13045e[i11][3];
                }
            }
            for (int i23 = 0; i23 < 8; i23 += 4) {
                for (int i24 = 2; i24 < 8; i24 += 4) {
                    f13044d[i11][(i23 << 3) + i24] = f13045e[i11][4];
                }
            }
            for (int i25 = 2; i25 < 8; i25 += 4) {
                for (int i26 = 0; i26 < 8; i26 += 4) {
                    f13044d[i11][(i25 << 3) + i26] = f13045e[i11][4];
                }
            }
        }
    }

    public static void a(int[] iArr) {
        for (int i11 = 0; i11 < 16; i11 += 4) {
            int i12 = iArr[i11];
            int i13 = i11 + 3;
            int i14 = iArr[i13];
            int i15 = i12 + i14;
            int i16 = i11 + 1;
            int i17 = iArr[i16];
            int i18 = i11 + 2;
            int i19 = iArr[i18];
            int i21 = i17 + i19;
            int i22 = i17 - i19;
            int i23 = i12 - i14;
            iArr[i11] = i15 + i21;
            iArr[i16] = (i23 << 1) + i22;
            iArr[i18] = i15 - i21;
            iArr[i13] = i23 - (i22 << 1);
        }
        for (int i24 = 0; i24 < 4; i24++) {
            int i25 = iArr[i24];
            int i26 = i24 + 12;
            int i27 = iArr[i26];
            int i28 = i25 + i27;
            int i29 = i24 + 4;
            int i31 = iArr[i29];
            int i32 = i24 + 8;
            int i33 = iArr[i32];
            int i34 = i31 + i33;
            int i35 = i31 - i33;
            int i36 = i25 - i27;
            iArr[i24] = i28 + i34;
            iArr[i29] = (i36 << 1) + i35;
            iArr[i32] = i28 - i34;
            iArr[i26] = i36 - (i35 << 1);
        }
    }

    public static void b(int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = i11 + i12;
        int i14 = i11 - i12;
        int i15 = iArr[2];
        int i16 = iArr[3];
        int i17 = i15 + i16;
        int i18 = i15 - i16;
        iArr[0] = i13 + i17;
        iArr[1] = i14 + i18;
        iArr[2] = i13 - i17;
        iArr[3] = i14 - i18;
    }

    public static void c(int[] iArr) {
        int i11 = iArr[2];
        iArr[2] = iArr[4];
        iArr[4] = i11;
        int i12 = iArr[3];
        iArr[3] = iArr[5];
        iArr[5] = i12;
        int i13 = iArr[10];
        iArr[10] = iArr[12];
        iArr[12] = i13;
        int i14 = iArr[11];
        iArr[11] = iArr[13];
        iArr[13] = i14;
    }
}
