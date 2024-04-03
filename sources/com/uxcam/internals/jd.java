package com.uxcam.internals;

public class jd implements hg {
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
                iu.a(iArr2[i11], iArr3[i11], iArr4[i11], iArr5, i12);
                i14++;
                i11++;
                i12 += 3;
            }
        }
    }
}
