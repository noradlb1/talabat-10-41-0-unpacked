package com.c.c;

public final class c {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9225(char[] cArr, char[] cArr2, int i11) {
        char c11 = cArr2[(i11 + 2) % 4];
        int i12 = (i11 + 3) % 4;
        cArr2[i12] = (char) (((cArr[i12] * 32718) + c11) / 65535);
        cArr[i12] = (char) (((cArr[i11 % 4] * 32718) + c11) % 65535);
    }
}
