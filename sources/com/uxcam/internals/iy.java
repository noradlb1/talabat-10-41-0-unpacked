package com.uxcam.internals;

public class iy implements hg {
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
                iu.a(iArr2[i11], iArr3[i12], iArr4[i12], iArr5, i11 * 3);
                int i15 = i11 + 1;
                iu.a(iArr2[i15], iArr3[i12], iArr4[i12], iArr5, i15 * 3);
                i11 += 2;
                i12++;
            }
        }
    }
}
