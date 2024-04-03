package com.c.c;

public final class d {
    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m9226(int[] iArr) {
        for (int i11 = 0; i11 < iArr.length / 2; i11++) {
            int i12 = iArr[i11];
            iArr[i11] = iArr[(iArr.length - i11) - 1];
            iArr[(iArr.length - i11) - 1] = i12;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int m9227(int i11) {
        int[][] iArr = a.f450.f452;
        return ((iArr[0][i11 >>> 24] + iArr[1][(i11 >>> 16) & 255]) ^ iArr[2][(i11 >>> 8) & 255]) + iArr[3][i11 & 255];
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int[] m9228(char[] cArr, int[] iArr, boolean z11) {
        int i11 = (cArr[0] << 16) + cArr[1];
        int i12 = (cArr[2] << 16) + cArr[3];
        if (!z11) {
            m9226(iArr);
        }
        int i13 = 0;
        while (i13 < 16) {
            int i14 = i11 ^ iArr[i13];
            i13++;
            int r92 = i12 ^ m9227(i14);
            i12 = i14;
            i11 = r92;
        }
        int i15 = i11 ^ iArr[16];
        int i16 = iArr[17] ^ i12;
        int[] iArr2 = {i16, i15};
        cArr[0] = (char) (i16 >>> 16);
        cArr[1] = (char) i16;
        cArr[2] = (char) (i15 >>> 16);
        cArr[3] = (char) i15;
        if (!z11) {
            m9226(iArr);
        }
        return iArr2;
    }
}
