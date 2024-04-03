package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.BinaryOperator;
import j$.util.function.C0158i0;
import java.util.concurrent.CountedCompleter;

class O0 extends C0219f {

    /* renamed from: h  reason: collision with root package name */
    protected final C0314y0 f28996h;

    /* renamed from: i  reason: collision with root package name */
    protected final C0158i0 f28997i;

    /* renamed from: j  reason: collision with root package name */
    protected final BinaryOperator f28998j;

    O0(O0 o02, Spliterator spliterator) {
        super((C0219f) o02, spliterator);
        this.f28996h = o02.f28996h;
        this.f28997i = o02.f28997i;
        this.f28998j = o02.f28998j;
    }

    O0(C0314y0 y0Var, Spliterator spliterator, C0158i0 i0Var, C0249l lVar) {
        super(y0Var, spliterator);
        this.f28996h = y0Var;
        this.f28997i = i0Var;
        this.f28998j = lVar;
    }

    /* access modifiers changed from: protected */
    public final Object a() {
        C0 c02 = (C0) this.f28997i.apply(this.f28996h.N0(this.f29138b));
        this.f28996h.g1(this.f29138b, c02);
        return c02.build();
    }

    /* access modifiers changed from: protected */
    public final C0219f e(Spliterator spliterator) {
        return new O0(this, spliterator);
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        C0219f fVar = this.f29140d;
        if (!(fVar == null)) {
            f((H0) this.f28998j.apply((H0) ((O0) fVar).c(), (H0) ((O0) this.f29141e).c()));
        }
        super.onCompletion(countedCompleter);
    }
}
