package com.uxcam.internals;

import java.util.Arrays;

public class df {

    /* renamed from: a  reason: collision with root package name */
    public int[] f13192a;

    /* renamed from: b  reason: collision with root package name */
    public int f13193b;

    public df() {
        int[] a11 = a(128);
        this.f13192a = a11;
        Arrays.fill(a11, Integer.MIN_VALUE);
    }

    public void a(int i11, int i12) {
        if (i12 != Integer.MIN_VALUE) {
            int[] iArr = this.f13192a;
            if (iArr.length <= i11) {
                int i13 = i11 + 128;
                int[] iArr2 = new int[i13];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                Arrays.fill(iArr2, this.f13192a.length, i13, Integer.MIN_VALUE);
                this.f13192a = iArr2;
            }
            int[] iArr3 = this.f13192a;
            if (iArr3[i11] == Integer.MIN_VALUE) {
                this.f13193b++;
            }
            iArr3[i11] = i12;
            return;
        }
        throw new IllegalArgumentException("This implementation can not store -2147483648");
    }

    public int b(int i11) {
        int[] iArr = this.f13192a;
        return (i11 >= iArr.length ? null : Integer.valueOf(iArr[i11])).intValue();
    }

    public final int[] a(int i11) {
        return new int[i11];
    }
}
