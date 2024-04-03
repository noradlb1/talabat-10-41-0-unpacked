package com.uxcam.internals;

import java.util.Arrays;

public class de {

    /* renamed from: a  reason: collision with root package name */
    public int[] f13190a;

    /* renamed from: b  reason: collision with root package name */
    public int f13191b;

    public de() {
        this(128);
    }

    public int[] a() {
        int i11 = this.f13191b;
        int[] iArr = new int[i11];
        System.arraycopy(this.f13190a, 0, iArr, 0, i11);
        return iArr;
    }

    public de(int i11) {
        this.f13190a = new int[i11];
    }

    public void a(int i11) {
        int i12 = this.f13191b;
        int[] iArr = this.f13190a;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 128)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f13190a = iArr2;
        }
        int[] iArr3 = this.f13190a;
        int i13 = this.f13191b;
        this.f13191b = i13 + 1;
        iArr3[i13] = i11;
    }

    public void a(int i11, int i12, int i13) {
        int[] iArr = this.f13190a;
        if (i12 > iArr.length) {
            int[] iArr2 = new int[(i12 + 128)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f13190a = iArr2;
        }
        Arrays.fill(this.f13190a, i11, i12, i13);
        this.f13191b = Math.max(this.f13191b, i12);
    }
}
