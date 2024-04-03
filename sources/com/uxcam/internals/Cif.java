package com.uxcam.internals;

/* renamed from: com.uxcam.internals.if  reason: invalid class name */
public class Cif {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f13627a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f13628b;

    public Cif(int[] iArr, int[] iArr2) {
        this.f13627a = iArr;
        this.f13628b = iArr2;
        a();
    }

    public final void a() {
        de deVar = new de(128);
        de deVar2 = new de(128);
        a(0, 0, 0, deVar, deVar2);
        deVar.a();
        deVar2.a();
    }

    public void a(ak akVar, int i11) {
        throw null;
    }

    public final int a(int i11, int i12, int i13, de deVar, de deVar2) {
        int i14 = i11 + 256;
        deVar.a(i11, i14, -1);
        deVar2.a(i11, i14, 0);
        int i15 = i12 << 3;
        int i16 = i14;
        int i17 = 0;
        while (true) {
            int[] iArr = this.f13628b;
            if (i17 >= iArr.length) {
                return i16;
            }
            int i18 = iArr[i17];
            if (i18 > i15 && (i12 <= 0 || (this.f13627a[i17] >>> (32 - i15)) == i13)) {
                int i19 = this.f13627a[i17] >>> ((32 - i15) - 8);
                int i21 = i19 & 255;
                int i22 = i18 - i15;
                if (i22 <= 8) {
                    for (int i23 = 0; i23 < (1 << (8 - i22)); i23++) {
                        int i24 = i11 + i21 + i23;
                        deVar.f13190a[i24] = i17;
                        deVar2.f13190a[i24] = i22;
                    }
                } else {
                    int i25 = i21 + i11;
                    int[] iArr2 = deVar.f13190a;
                    if (iArr2[i25] == -1) {
                        iArr2[i25] = i16;
                        i16 = a(i16, i12 + 1, i19, deVar, deVar2);
                    }
                }
            }
            i17++;
        }
    }
}
