package com.uxcam.internals;

public class ar {
    public static void a(ak akVar, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= 15) {
                i12 = 0;
                break;
            }
            int i14 = (1 << i12) + i13;
            if (i11 < i14) {
                break;
            }
            i12++;
            i13 = i14;
        }
        akVar.a(0, i12);
        akVar.b(1);
        akVar.a(i11 - i13, i12);
    }

    public static void a(ak akVar, long j11, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            akVar.b(((int) (j11 >> ((i11 - i12) - 1))) & 1);
        }
    }
}
