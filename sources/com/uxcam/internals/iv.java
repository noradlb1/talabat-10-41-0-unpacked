package com.uxcam.internals;

public class iv implements hg {
    public void a(ek ekVar, ek ekVar2) {
        int i11 = 0;
        int[] iArr = ekVar.f13284d[0];
        int[] iArr2 = ekVar2.f13284d[0];
        int i12 = 0;
        while (true) {
            if (i12 >= ekVar.a(0) * ekVar.b(0)) {
                break;
            }
            iArr2[i12] = ((iArr[i12] * 7168) >> 13) + 16;
            i12++;
        }
        int[] iArr3 = ekVar.f13284d[1];
        int[] iArr4 = ekVar2.f13284d[1];
        int i13 = 0;
        while (true) {
            if (i13 >= ekVar.a(1) * ekVar.b(1)) {
                break;
            }
            iArr4[i13] = (((iArr3[i13] - 128) * 7168) >> 13) + 128;
            i13++;
        }
        int[] iArr5 = ekVar.f13284d[2];
        int[] iArr6 = ekVar2.f13284d[2];
        while (true) {
            if (i11 < ekVar.a(2) * ekVar.b(2)) {
                iArr6[i11] = (((iArr5[i11] - 128) * 7168) >> 13) + 128;
                i11++;
            } else {
                return;
            }
        }
    }
}
