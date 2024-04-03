package com.uxcam.internals;

public class aq {
    public static int a(aj ajVar) {
        int b11 = b(ajVar);
        int i11 = b11 & 1;
        return ((b11 >> 1) + i11) * ((i11 << 1) - 1);
    }

    public static int b(aj ajVar) {
        int i11 = 0;
        while (ajVar.a() == 0 && i11 < 31) {
            i11++;
        }
        if (i11 <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i11) - 1)) + ((long) ajVar.b(i11)));
    }
}
