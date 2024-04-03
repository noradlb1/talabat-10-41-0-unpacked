package com.c.c;

public final class g {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9231(char[] cArr, char c11, char c12, char c13, char c14) {
        char c15 = 58224;
        for (int i11 = 0; i11 < 16; i11++) {
            char c16 = cArr[1];
            char c17 = cArr[0];
            char c18 = (char) (c16 - (((c17 + c15) ^ ((c17 << 4) + c13)) ^ ((c17 >>> 5) + c14)));
            cArr[1] = c18;
            cArr[0] = (char) (c17 - (((c18 + c15) ^ ((c18 << 4) + c11)) ^ ((c18 >>> 5) + c12)));
            c15 = (char) (c15 - 40503);
        }
    }
}
