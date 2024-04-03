package com.uxcam.internals;

public class iw implements hg {
    public iw(int i11, int i12) {
    }

    public final void a(ek ekVar, ek ekVar2) {
        int i11;
        int i12;
        int i13;
        ek ekVar3 = ekVar2;
        int[][] iArr = ekVar.f13284d;
        int[] iArr2 = iArr[0];
        int[] iArr3 = iArr[1];
        int[] iArr4 = iArr[2];
        int[] iArr5 = ekVar3.f13284d[0];
        int i14 = ekVar3.f13282b;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            i11 = ekVar3.f13283c;
            if (i15 >= (i11 >> 1)) {
                break;
            }
            int i18 = 0;
            while (true) {
                i13 = ekVar3.f13282b;
                if (i18 >= (i13 >> 1)) {
                    break;
                }
                int i19 = (i18 << 1) + i16;
                ja.a((iArr2[i19] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i19 * 3);
                int i21 = i19 + 1;
                ja.a((iArr2[i21] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i21 * 3);
                int i22 = i19 + i14;
                ja.a((iArr2[i22] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i22 * 3);
                int i23 = i22 + 1;
                ja.a((iArr2[i23] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i23 * 3);
                i17++;
                i18++;
            }
            if ((i13 & 1) != 0) {
                int i24 = (i13 - 1) + i16;
                ja.a((iArr2[i24] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i24 * 3);
                int i25 = i24 + i14;
                ja.a((iArr2[i25] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i25 * 3);
                i17++;
            }
            i16 += i14 * 2;
            i15++;
        }
        if ((i11 & 1) != 0) {
            int i26 = 0;
            while (true) {
                i12 = ekVar3.f13282b;
                if (i26 >= (i12 >> 1)) {
                    break;
                }
                int i27 = (i26 << 1) + i16;
                ja.a((iArr2[i27] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i27 * 3);
                int i28 = i27 + 1;
                ja.a((iArr2[i28] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i28 * 3);
                i17++;
                i26++;
            }
            if ((i12 & 1) != 0) {
                int i29 = (i12 - 1) + i16;
                ja.a((iArr2[i29] << 0) >> 0, (iArr3[i17] << 0) >> 0, (iArr4[i17] << 0) >> 0, iArr5, i29 * 3);
            }
        }
    }
}
