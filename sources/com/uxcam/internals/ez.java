package com.uxcam.internals;

public class ez implements hg {
    public static final int a(int i11) {
        if (i11 < 0) {
            return 0;
        }
        if (i11 > 255) {
            return 255;
        }
        return i11;
    }

    public static final void a(int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2, int i15, int[] iArr3, int i16) {
        int i17 = (i13 * 25) + (i12 * 129) + (i11 * 66);
        int i18 = (i11 * -38) - (i12 * 74);
        int i19 = ((i11 * 112) - (i12 * 94)) - (i13 * 18);
        iArr[i14] = a(((i17 + 128) >> 8) + 16);
        iArr2[i15] = a(((((i13 * 112) + i18) + 128) >> 8) + 128) + iArr2[i15];
        iArr3[i16] = a(((i19 + 128) >> 8) + 128) + iArr3[i16];
    }

    public void a(ek ekVar, ek ekVar2) {
        ek ekVar3 = ekVar;
        ek ekVar4 = ekVar2;
        int[] iArr = ekVar3.f13284d[0];
        int[][] iArr2 = ekVar4.f13284d;
        int i11 = ekVar3.f13282b * 3;
        int i12 = ekVar4.f13282b;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < (ekVar3.f13283c >> 1); i16++) {
            for (int i17 = 0; i17 < (ekVar3.f13282b >> 1); i17++) {
                int[] iArr3 = iArr2[1];
                iArr3[i13] = 0;
                int[] iArr4 = iArr2[2];
                iArr4[i13] = 0;
                int i18 = i13;
                int i19 = i13;
                a(iArr[i15], iArr[i15 + 1], iArr[i15 + 2], iArr2[0], i14, iArr3, i18, iArr4, i19);
                int[] iArr5 = iArr2[0];
                iArr5[i14] = iArr5[i14];
                int i21 = i15 + i11;
                int i22 = i14 + i12;
                a(iArr[i21], iArr[i21 + 1], iArr[i21 + 2], iArr5, i22, iArr2[1], i18, iArr2[2], i19);
                int[] iArr6 = iArr2[0];
                iArr6[i22] = iArr6[i22];
                int i23 = i14 + 1;
                a(iArr[i15 + 3], iArr[i15 + 4], iArr[i15 + 5], iArr6, i23, iArr2[1], i18, iArr2[2], i19);
                int[] iArr7 = iArr2[0];
                iArr7[i23] = iArr7[i23];
                int i24 = iArr[i21 + 3];
                int i25 = iArr[i21 + 4];
                int i26 = iArr[i21 + 5];
                int i27 = i23 + i12;
                a(i24, i25, i26, iArr7, i27, iArr2[1], i18, iArr2[2], i19);
                int[] iArr8 = iArr2[0];
                iArr8[i27] = iArr8[i27];
                i14 = i23 + 1;
                int[] iArr9 = iArr2[1];
                iArr9[i13] = iArr9[i13] >> 2;
                int[] iArr10 = iArr2[2];
                iArr10[i13] = iArr10[i13] >> 2;
                i13++;
                i15 += 6;
            }
            i14 += i12;
            i15 += i11;
        }
    }
}
