package com.uxcam.internals;

public class ja implements hg {

    /* renamed from: a  reason: collision with root package name */
    public final int f13669a;

    public ja(int i11, int i12) {
        this.f13669a = i11;
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

    public static final void a(int i11, int i12, int i13, int[] iArr, int i14) {
        int i15 = i12 - 128;
        int i16 = i13 - 128;
        int i17 = (i11 - 16) * 298;
        iArr[i14] = a((((i15 * 516) + i17) + 128) >> 8);
        iArr[i14 + 1] = a((((i17 - (i15 * 100)) - (i16 * 208)) + 128) >> 8);
        iArr[i14 + 2] = a((((i16 * 409) + i17) + 128) >> 8);
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
            for (int i14 = 0; i14 < ekVar2.f13282b; i14 += 2) {
                int i15 = this.f13669a;
                a((iArr2[i11] << 0) >> i15, (iArr3[i12] << 0) >> i15, (iArr4[i12] << 0) >> i15, iArr5, i11 * 3);
                int i16 = i11 + 1;
                int i17 = this.f13669a;
                a((iArr2[i16] << 0) >> i17, (iArr3[i12] << 0) >> i17, (iArr4[i12] << 0) >> i17, iArr5, i16 * 3);
                i11 += 2;
                i12++;
            }
        }
    }
}
