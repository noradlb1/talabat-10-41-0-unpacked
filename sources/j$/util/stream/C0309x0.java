package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.J;

/* renamed from: j$.util.stream.x0  reason: case insensitive filesystem */
final class C0309x0 extends C0209d {

    /* renamed from: j  reason: collision with root package name */
    private final C0304w0 f29267j;

    C0309x0(C0304w0 w0Var, C0314y0 y0Var, Spliterator spliterator) {
        super(y0Var, spliterator);
        this.f29267j = w0Var;
    }

    C0309x0(C0309x0 x0Var, Spliterator spliterator) {
        super((C0209d) x0Var, spliterator);
        this.f29267j = x0Var.f29267j;
    }

    /* access modifiers changed from: protected */
    public final Object a() {
        Boolean valueOf;
        C0314y0 y0Var = this.f29137a;
        C0294u0 u0Var = (C0294u0) this.f29267j.f29257b.get();
        y0Var.g1(this.f29138b, u0Var);
        boolean z11 = u0Var.f29241b;
        if (z11 != this.f29267j.f29256a.f29251b || (valueOf = Boolean.valueOf(z11)) == null) {
            return null;
        }
        J.a(this.f29103h, valueOf);
        return null;
    }

    /* access modifiers changed from: protected */
    public final C0219f e(Spliterator spliterator) {
        return new C0309x0(this, spliterator);
    }

    /* access modifiers changed from: protected */
    public final Object j() {
        return Boolean.valueOf(!this.f29267j.f29256a.f29251b);
    }
}
