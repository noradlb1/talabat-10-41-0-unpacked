package com.uxcam.internals;

public class jc implements hg {

    /* renamed from: a  reason: collision with root package name */
    public final int f13673a;

    public jc(int i11, int i12) {
        this.f13673a = i12;
    }

    public final void a(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = iArr[i12] >> i11;
        }
    }

    public final void b(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = iArr[i12] << i11;
        }
    }

    public final void a(int[] iArr, int[] iArr2, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i12 / 2; i15++) {
            int i16 = 0;
            while (i16 < i11) {
                iArr2[i14] = ((iArr[i13] + iArr[i13 + i11]) + 1) >> 1;
                i16++;
                i14++;
                i13++;
            }
            i13 += i11;
        }
    }

    public void a(ek ekVar, ek ekVar2) {
        System.arraycopy(ekVar.f13284d[0], 0, ekVar2.f13284d[0], 0, ekVar.f13282b * ekVar.f13283c);
        a(ekVar.f13284d[1], ekVar2.f13284d[1], ekVar.b(1), ekVar.a(1));
        a(ekVar.f13284d[2], ekVar2.f13284d[2], ekVar.b(2), ekVar.a(2));
        int i11 = this.f13673a;
        if (i11 < 0) {
            b(ekVar2.f13284d[0], 0 - i11);
            b(ekVar2.f13284d[1], 0 - this.f13673a);
            b(ekVar2.f13284d[2], 0 - this.f13673a);
        } else if (i11 > 0) {
            a(ekVar2.f13284d[0], i11 - 0);
            a(ekVar2.f13284d[1], this.f13673a - 0);
            a(ekVar2.f13284d[2], this.f13673a - 0);
        }
    }
}
