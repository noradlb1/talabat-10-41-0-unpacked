package com.uxcam.internals;

public class fb implements hg {

    /* renamed from: a  reason: collision with root package name */
    public final int f13306a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13307b;

    public fb(int i11, int i12) {
        this.f13306a = i11;
        this.f13307b = i12 + 1;
    }

    public void a(ek ekVar, ek ekVar2) {
        ek ekVar3 = ekVar;
        int[] iArr = ekVar3.f13284d[0];
        int[][] iArr2 = ekVar2.f13284d;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < ekVar3.f13283c; i13++) {
            int i14 = 0;
            while (i14 < (ekVar3.f13282b >> 1)) {
                int[] iArr3 = iArr2[1];
                iArr3[i11] = 0;
                int[] iArr4 = iArr2[2];
                iArr4[i11] = 0;
                int i15 = i11 << 1;
                int i16 = i12 + 1;
                int i17 = i16 + 1;
                int i18 = i17 + 1;
                int i19 = i11;
                int i21 = i11;
                fa.a(iArr[i12], iArr[i16], iArr[i17], iArr2[0], i15, iArr3, i19, iArr4, i21);
                int[] iArr5 = iArr2[0];
                iArr5[i15] = (iArr5[i15] << this.f13306a) >> 0;
                int i22 = i18 + 1;
                int i23 = iArr[i18];
                int i24 = i22 + 1;
                int i25 = i24 + 1;
                int i26 = i15 + 1;
                fa.a(i23, iArr[i22], iArr[i24], iArr5, i26, iArr2[1], i19, iArr2[2], i21);
                int[] iArr6 = iArr2[0];
                int i27 = iArr6[i26];
                int i28 = this.f13306a;
                iArr6[i26] = (i27 << i28) >> 0;
                int[] iArr7 = iArr2[1];
                int i29 = this.f13307b;
                iArr7[i11] = (iArr7[i11] << i28) >> i29;
                int[] iArr8 = iArr2[2];
                iArr8[i11] = (iArr8[i11] << i28) >> i29;
                i11++;
                i14++;
                i12 = i25;
            }
        }
    }
}
