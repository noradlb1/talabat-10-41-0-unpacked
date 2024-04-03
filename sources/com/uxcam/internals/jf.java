package com.uxcam.internals;

public class jf implements hg {

    /* renamed from: a  reason: collision with root package name */
    public final int f13674a;

    public jf(int i11, int i12) {
        this.f13674a = i11;
    }

    public static int a(int i11) {
        if (i11 < 0) {
            return 0;
        }
        if (i11 > 255) {
            return 255;
        }
        return i11;
    }

    public void a(ek ekVar, ek ekVar2) {
        int[][] iArr = ekVar.f13284d;
        int[] iArr2 = iArr[0];
        int[] iArr3 = iArr[1];
        int[] iArr4 = iArr[2];
        int[] iArr5 = ekVar2.f13284d[0];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < ekVar2.f13283c; i13++) {
            int i14 = 0;
            while (i14 < ekVar2.f13282b) {
                int i15 = this.f13674a;
                int i16 = (iArr2[i11] << 0) >> i15;
                int i17 = ((iArr3[i11] << 0) >> i15) - 128;
                int i18 = ((iArr4[i11] << 0) >> i15) - 128;
                int i19 = (i16 - 16) * 298;
                iArr5[i12] = a((((i17 * 516) + i19) + 128) >> 8);
                iArr5[i12 + 1] = a((((i19 - (i17 * 100)) - (i18 * 208)) + 128) >> 8);
                iArr5[i12 + 2] = a((((i18 * 409) + i19) + 128) >> 8);
                i14++;
                i11++;
                i12 += 3;
            }
        }
    }
}
