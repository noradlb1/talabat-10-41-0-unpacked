package com.uxcam.internals;

public enum bc {
    RGB(3, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV420(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV420J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV422(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV422J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV444(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444J(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV422_10(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    MONO(1, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444_10(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0});
    

    /* renamed from: a  reason: collision with root package name */
    public int f13057a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f13058b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f13059c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f13060d;

    /* access modifiers changed from: public */
    bc(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f13057a = i11;
        this.f13058b = iArr;
        this.f13059c = iArr2;
        this.f13060d = iArr3;
    }
}
