package com.c.c;

public final class b {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static char[] m9224(long j11, char[] cArr) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i11 = 0;
        int i12 = 4;
        for (int i13 = 0; i13 < cArr.length; i13++) {
            if ((((j11 >>> i13) & 1) != 1 || i11 >= 4) && i12 < length) {
                cArr2[i12] = cArr[i13];
                i12++;
            } else {
                cArr2[i11] = cArr[i13];
                i11++;
            }
        }
        return cArr2;
    }
}
