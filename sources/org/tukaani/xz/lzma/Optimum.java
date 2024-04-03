package org.tukaani.xz.lzma;

final class Optimum {
    private static final int INFINITY_PRICE = 1073741824;

    /* renamed from: a  reason: collision with root package name */
    public final State f63474a = new State();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f63475b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    public int f63476c;

    /* renamed from: d  reason: collision with root package name */
    public int f63477d;

    /* renamed from: e  reason: collision with root package name */
    public int f63478e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63479f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63480g;

    /* renamed from: h  reason: collision with root package name */
    public int f63481h;

    /* renamed from: i  reason: collision with root package name */
    public int f63482i;

    public void a() {
        this.f63476c = 1073741824;
    }

    public void b(int i11, int i12, int i13) {
        this.f63476c = i11;
        this.f63477d = i12;
        this.f63478e = i13;
        this.f63479f = false;
    }

    public void c(int i11, int i12, int i13) {
        this.f63476c = i11;
        this.f63477d = i12 + 1;
        this.f63478e = i13;
        this.f63479f = true;
        this.f63480g = false;
    }

    public void d(int i11, int i12, int i13, int i14, int i15) {
        this.f63476c = i11;
        this.f63477d = i14 + i12 + 1;
        this.f63478e = i15;
        this.f63479f = true;
        this.f63480g = true;
        this.f63481h = i12;
        this.f63482i = i13;
    }
}
