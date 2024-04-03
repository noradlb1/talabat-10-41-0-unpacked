package j$.util.stream;

import j$.util.Spliterator;

/* renamed from: j$.util.stream.s1  reason: case insensitive filesystem */
final class C0285s1 extends C0290t1 {

    /* renamed from: h  reason: collision with root package name */
    private final Object[] f29220h;

    C0285s1(Spliterator spliterator, C0314y0 y0Var, Object[] objArr) {
        super(objArr.length, spliterator, y0Var);
        this.f29220h = objArr;
    }

    C0285s1(C0285s1 s1Var, Spliterator spliterator, long j11, long j12) {
        super(s1Var, spliterator, j11, j12, s1Var.f29220h.length);
        this.f29220h = s1Var.f29220h;
    }

    /* access modifiers changed from: package-private */
    public final C0290t1 a(Spliterator spliterator, long j11, long j12) {
        return new C0285s1(this, spliterator, j11, j12);
    }

    public final void accept(Object obj) {
        int i11 = this.f29235f;
        if (i11 < this.f29236g) {
            Object[] objArr = this.f29220h;
            this.f29235f = i11 + 1;
            objArr[i11] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f29235f));
    }
}
