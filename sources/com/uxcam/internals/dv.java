package com.uxcam.internals;

public class dv {
    public static final int a(int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = i11 >> 31;
        return (((i11 ^ i12) - i12) << 1) - ((~i11) >>> 31);
    }

    public static final int a(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }
}
