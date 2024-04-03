package com.uxcam.internals;

public class ix implements hg {
    public ix(int i11, int i12) {
    }

    public static final void a(int[] iArr, int[] iArr2, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = (i12 * i16) + i11;
        int i21 = 0;
        for (int i22 = 0; i22 < i17; i22++) {
            int i23 = 0;
            while (i23 < i15) {
                iArr2[i19] = (iArr[i21] & 255) << 2;
                i19 += i13;
                i23++;
                i21++;
            }
            int i24 = i19 - i13;
            int i25 = i15 * i13;
            while (i25 < i16) {
                iArr2[i19] = iArr2[i24];
                i19 += i13;
                i25 += i13;
            }
            i19 += (i14 - 1) * i16;
        }
        int i26 = i19 - (i14 * i16);
        int i27 = i17 * i14;
        while (i27 < i18) {
            int i28 = 0;
            while (i28 < i16) {
                iArr2[i19] = iArr2[i26 + i28];
                i19 += i13;
                i28 += i13;
            }
            i19 += (i14 - 1) * i16;
            i27 += i14;
        }
    }

    public void a(ek ekVar, ek ekVar2) {
        ek ekVar3 = ekVar;
        ek ekVar4 = ekVar2;
        int[] iArr = ekVar3.f13284d[0];
        int[] iArr2 = ekVar4.f13284d[0];
        int i11 = ekVar3.f13282b;
        int i12 = ekVar4.f13282b;
        int i13 = ekVar4.f13283c;
        int length = iArr.length / i11;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = 0;
            while (i17 < i11) {
                iArr2[i14] = (iArr[i15] & 255) << 2;
                i17++;
                i14++;
                i15++;
            }
            int i18 = i11;
            while (i18 < i12) {
                iArr2[i14] = iArr2[i11 - 1];
                i18++;
                i14++;
            }
        }
        int i19 = (length - 1) * i12;
        while (length < i13) {
            int i21 = 0;
            while (i21 < i12) {
                iArr2[i14] = iArr2[i19 + i21];
                i21++;
                i14++;
            }
            length++;
        }
        a(ekVar3.f13284d[1], ekVar4.f13284d[1], 0, 0, 1, 2, ekVar3.f13282b >> 1, ekVar4.f13282b >> 1, ekVar3.f13283c >> 1, ekVar4.f13283c);
        a(ekVar3.f13284d[1], ekVar4.f13284d[1], 0, 1, 1, 2, ekVar3.f13282b >> 1, ekVar4.f13282b >> 1, ekVar3.f13283c >> 1, ekVar4.f13283c);
        a(ekVar3.f13284d[2], ekVar4.f13284d[2], 0, 0, 1, 2, ekVar3.f13282b >> 1, ekVar4.f13282b >> 1, ekVar3.f13283c >> 1, ekVar4.f13283c);
        a(ekVar3.f13284d[2], ekVar4.f13284d[2], 0, 1, 1, 2, ekVar3.f13282b >> 1, ekVar4.f13282b >> 1, ekVar3.f13283c >> 1, ekVar4.f13283c);
    }
}
