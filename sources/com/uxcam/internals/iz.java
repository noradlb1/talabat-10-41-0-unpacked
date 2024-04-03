package com.uxcam.internals;

public class iz implements hg {
    public final void a(int[] iArr, int[] iArr2, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i12 / 2; i15++) {
            int i16 = 0;
            while (i16 < i11) {
                iArr2[i14] = ((((((iArr[i13 + i11] - 128) * 7168) >> 13) + 128) + ((((iArr[i13] - 128) * 7168) >> 13) + 128)) + 1) >> 1;
                i16++;
                i14++;
                i13++;
            }
            i13 += i11;
        }
    }

    public void a(ek ekVar, ek ekVar2) {
        int[] iArr = ekVar.f13284d[0];
        int[] iArr2 = ekVar2.f13284d[0];
        int i11 = 0;
        while (true) {
            if (i11 < ekVar.a(0) * ekVar.b(0)) {
                iArr2[i11] = ((iArr[i11] * 7168) >> 13) + 16;
                i11++;
            } else {
                a(ekVar.f13284d[1], ekVar2.f13284d[1], ekVar.b(1), ekVar.a(1));
                a(ekVar.f13284d[2], ekVar2.f13284d[2], ekVar.b(2), ekVar.a(2));
                return;
            }
        }
    }
}
