package com.uxcam.internals;

public class ig {

    /* renamed from: a  reason: collision with root package name */
    public final df f13629a = new df();

    /* renamed from: b  reason: collision with root package name */
    public final df f13630b = new df();

    /* renamed from: c  reason: collision with root package name */
    public final de f13631c = new de();

    /* renamed from: d  reason: collision with root package name */
    public final de f13632d = new de();

    public class aa extends Cif {
        public aa(int[] iArr, int[] iArr2) {
            super(iArr, iArr2);
        }

        public void a(ak akVar, int i11) {
            int b11 = ig.this.f13629a.b(i11);
            int i12 = this.f13627a[b11];
            int i13 = this.f13628b[b11];
            akVar.a(i12 >>> (32 - i13), i13);
        }
    }

    public ig a(int i11, String str) {
        int parseInt = Integer.parseInt(str, 2);
        int length = str.length();
        this.f13631c.a(parseInt << (32 - length));
        this.f13632d.a(length);
        this.f13629a.a(i11, this.f13631c.f13191b - 1);
        this.f13630b.a(this.f13631c.f13191b - 1, i11);
        return this;
    }

    public Cif a() {
        return new aa(this.f13631c.a(), this.f13632d.a());
    }
}
