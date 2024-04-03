package com.uxcam.internals;

public class iu implements hg {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13665a = a(0.71414d);

    /* renamed from: b  reason: collision with root package name */
    public static final int f13666b = a(1.772d);

    /* renamed from: c  reason: collision with root package name */
    public static final int f13667c = (-a(0.34414d));

    /* renamed from: d  reason: collision with root package name */
    public static final int f13668d = a(1.402d);

    public static final int a(double d11) {
        return (int) ((d11 * 1024.0d) + 0.5d);
    }

    public static final void a(int i11, int i12, int i13, int[] iArr, int i14) {
        int i15 = i11 << 10;
        int i16 = i12 - 128;
        int i17 = i13 - 128;
        int i18 = (((f13668d * i17) + 512) + i15) >> 10;
        iArr[i14] = dv.a((i15 + ((f13666b * i16) + 512)) >> 10, 0, 255);
        iArr[i14 + 1] = dv.a(((((f13667c * i16) - (f13665a * i17)) + 512) + i15) >> 10, 0, 255);
        iArr[i14 + 2] = dv.a(i18, 0, 255);
    }

    public final void a(ek ekVar, ek ekVar2) {
        int i11;
        int i12;
        int i13;
        ek ekVar3 = ekVar2;
        int[][] iArr = ekVar.f13284d;
        int i14 = 0;
        int[] iArr2 = iArr[0];
        int[] iArr3 = iArr[1];
        int[] iArr4 = iArr[2];
        int[] iArr5 = ekVar3.f13284d[0];
        int i15 = ekVar3.f13282b;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            i11 = ekVar3.f13283c;
            if (i16 >= (i11 >> 1)) {
                break;
            }
            int i19 = i14;
            while (true) {
                i13 = ekVar3.f13282b;
                if (i19 >= (i13 >> 1)) {
                    break;
                }
                int i21 = (i19 << 1) + i17;
                a(iArr2[i21], iArr3[i18], iArr4[i18], iArr5, i21 * 3);
                int i22 = i21 + 1;
                a(iArr2[i22], iArr3[i18], iArr4[i18], iArr5, i22 * 3);
                int i23 = i21 + i15;
                a(iArr2[i23], iArr3[i18], iArr4[i18], iArr5, i23 * 3);
                int i24 = i23 + 1;
                a(iArr2[i24], iArr3[i18], iArr4[i18], iArr5, i24 * 3);
                i18++;
                i19++;
            }
            if ((i13 & 1) != 0) {
                int i25 = (i13 - 1) + i17;
                a(iArr2[i25], iArr3[i18], iArr4[i18], iArr5, i25 * 3);
                int i26 = i25 + i15;
                a(iArr2[i26], iArr3[i18], iArr4[i18], iArr5, i26 * 3);
                i18++;
            }
            i17 += i15 * 2;
            i16++;
            i14 = 0;
        }
        if ((i11 & 1) != 0) {
            int i27 = 0;
            while (true) {
                i12 = ekVar3.f13282b;
                if (i27 >= (i12 >> 1)) {
                    break;
                }
                int i28 = (i27 << 1) + i17;
                a(iArr2[i28], iArr3[i18], iArr4[i18], iArr5, i28 * 3);
                int i29 = i28 + 1;
                a(iArr2[i29], iArr3[i18], iArr4[i18], iArr5, i29 * 3);
                i18++;
                i27++;
            }
            if ((i12 & 1) != 0) {
                int i31 = (i12 - 1) + i17;
                a(iArr2[i31], iArr3[i18], iArr4[i18], iArr5, i31 * 3);
            }
        }
    }
}
