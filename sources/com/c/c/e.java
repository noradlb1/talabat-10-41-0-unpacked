package com.c.c;

public final class e {
    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m9229(int[] iArr) {
        for (int i11 = 0; i11 < iArr.length / 2; i11++) {
            int i12 = iArr[i11];
            iArr[i11] = iArr[(iArr.length - i11) - 1];
            iArr[(iArr.length - i11) - 1] = i12;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9230(int i11, int i12, boolean z11, int i13, int[] iArr, int[][] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        if (!z11) {
            m9229(iArr);
        }
        int i14 = i11;
        int i15 = i12;
        int i16 = 0;
        while (i16 < i13) {
            int i17 = i14 ^ iArr4[i16];
            i16++;
            int i18 = i15 ^ ((iArr2[2][(i17 >>> 8) & 255] ^ (iArr2[0][i17 >>> 24] + iArr2[1][(i17 >>> 16) & 255])) + iArr2[3][i17 & 255]);
            i15 = i17;
            i14 = i18;
        }
        int i19 = i14 ^ iArr4[iArr4.length - 2];
        int i21 = i15 ^ iArr4[iArr4.length - 1];
        if (!z11) {
            m9229(iArr);
        }
        iArr3[0] = i21;
        iArr3[1] = i19;
    }
}
