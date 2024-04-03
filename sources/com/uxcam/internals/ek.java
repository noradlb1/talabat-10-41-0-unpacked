package com.uxcam.internals;

public class ek {

    /* renamed from: a  reason: collision with root package name */
    public final bc f13281a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13282b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13283c;

    /* renamed from: d  reason: collision with root package name */
    public final int[][] f13284d;

    public ek(int i11, int i12, int[][] iArr, bc bcVar) {
        this.f13282b = i11;
        this.f13283c = i12;
        this.f13284d = iArr;
        this.f13281a = bcVar;
    }

    public static ek a(int i11, int i12, bc bcVar) {
        int[] iArr = new int[4];
        for (int i13 = 0; i13 < bcVar.f13057a; i13++) {
            int i14 = bcVar.f13058b[i13];
            iArr[i14] = ((i11 >> bcVar.f13059c[i13]) * (i12 >> bcVar.f13060d[i13])) + iArr[i14];
        }
        int i15 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            i15 += iArr[i16] != 0 ? 1 : 0;
        }
        int[][] iArr2 = new int[i15][];
        int i17 = 0;
        for (int i18 = 0; i18 < 4; i18++) {
            int i19 = iArr[i18];
            if (i19 != 0) {
                iArr2[i17] = new int[i19];
                i17++;
            }
        }
        return new ek(i11, i12, iArr2, bcVar);
    }

    public int b(int i11) {
        return this.f13282b >> this.f13281a.f13059c[i11];
    }

    public int a(int i11) {
        return this.f13283c >> this.f13281a.f13060d[i11];
    }
}
