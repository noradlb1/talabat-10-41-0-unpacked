package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

final class Z1 extends C0219f {

    /* renamed from: h  reason: collision with root package name */
    private final C0314y0 f29074h;

    Z1(Z1 z12, Spliterator spliterator) {
        super((C0219f) z12, spliterator);
        this.f29074h = z12.f29074h;
    }

    Z1(C0314y0 y0Var, C0314y0 y0Var2, Spliterator spliterator) {
        super(y0Var2, spliterator);
        this.f29074h = y0Var;
    }

    /* access modifiers changed from: protected */
    public final Object a() {
        C0314y0 y0Var = this.f29137a;
        S1 f12 = this.f29074h.f1();
        y0Var.g1(this.f29138b, f12);
        return f12;
    }

    /* access modifiers changed from: protected */
    public final C0219f e(Spliterator spliterator) {
        return new Z1(this, spliterator);
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        C0219f fVar = this.f29140d;
        if (!(fVar == null)) {
            S1 s12 = (S1) ((Z1) fVar).c();
            s12.k((S1) ((Z1) this.f29141e).c());
            f(s12);
        }
        super.onCompletion(countedCompleter);
    }
}
