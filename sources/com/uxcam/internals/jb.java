package com.uxcam.internals;

public class jb implements hg {

    /* renamed from: a  reason: collision with root package name */
    public final int f13670a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13671b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13672c;

    public jb(int i11, int i12) {
        int i13 = i12 + 13;
        int i14 = i13 - i11;
        this.f13670a = i14;
        if (i14 >= 0) {
            this.f13671b = 128 << Math.max(i12 - i11, 0);
            this.f13672c = 128 << Math.max(i11 - i12, 0);
            return;
        }
        throw new IllegalArgumentException("Maximum upshift allowed: " + i13);
    }

    public final void a(int[] iArr, int[] iArr2, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i12 / 2; i15++) {
            int i16 = 0;
            while (i16 < i11) {
                int i17 = iArr[i13];
                int i18 = this.f13671b;
                int i19 = this.f13670a;
                int i21 = this.f13672c;
                iArr2[i14] = ((((((iArr[i13 + i11] - i18) * 9362) >> i19) + i21) + ((((i17 - i18) * 9362) >> i19) + i21)) + 1) >> 1;
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
                iArr2[i11] = ((iArr[i11] - 16) * 9362) >> this.f13670a;
                i11++;
            } else {
                a(ekVar.f13284d[1], ekVar2.f13284d[1], ekVar.b(1), ekVar.a(1));
                a(ekVar.f13284d[2], ekVar2.f13284d[2], ekVar.b(2), ekVar.a(2));
                return;
            }
        }
    }
}
