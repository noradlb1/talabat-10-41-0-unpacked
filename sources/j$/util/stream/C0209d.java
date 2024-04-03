package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.J;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.d  reason: case insensitive filesystem */
abstract class C0209d extends C0219f {

    /* renamed from: h  reason: collision with root package name */
    protected final AtomicReference f29103h;

    /* renamed from: i  reason: collision with root package name */
    protected volatile boolean f29104i;

    protected C0209d(C0209d dVar, Spliterator spliterator) {
        super((C0219f) dVar, spliterator);
        this.f29103h = dVar.f29103h;
    }

    protected C0209d(C0314y0 y0Var, Spliterator spliterator) {
        super(y0Var, spliterator);
        this.f29103h = new AtomicReference((Object) null);
    }

    public final Object c() {
        if (!(d() == null)) {
            return super.c();
        }
        Object obj = this.f29103h.get();
        return obj == null ? j() : obj;
    }

    public final void compute() {
        Object obj;
        Spliterator trySplit;
        Spliterator spliterator = this.f29138b;
        long estimateSize = spliterator.estimateSize();
        long j11 = this.f29139c;
        if (j11 == 0) {
            j11 = C0219f.g(estimateSize);
            this.f29139c = j11;
        }
        AtomicReference atomicReference = this.f29103h;
        boolean z11 = false;
        C0209d dVar = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z12 = dVar.f29104i;
            if (!z12) {
                C0219f d11 = dVar.d();
                while (true) {
                    C0209d dVar2 = (C0209d) d11;
                    if (z12 || dVar2 == null) {
                        break;
                    }
                    z12 = dVar2.f29104i;
                    d11 = dVar2.d();
                }
            }
            if (z12) {
                obj = dVar.j();
                break;
            } else if (estimateSize <= j11 || (trySplit = spliterator.trySplit()) == null) {
                obj = dVar.a();
            } else {
                C0209d dVar3 = (C0209d) dVar.e(trySplit);
                dVar.f29140d = dVar3;
                C0209d dVar4 = (C0209d) dVar.e(spliterator);
                dVar.f29141e = dVar4;
                dVar.setPendingCount(1);
                if (z11) {
                    spliterator = trySplit;
                    dVar = dVar3;
                    dVar3 = dVar4;
                } else {
                    dVar = dVar4;
                }
                z11 = !z11;
                dVar3.fork();
                estimateSize = spliterator.estimateSize();
            }
        }
        dVar.f(obj);
        dVar.tryComplete();
    }

    /* access modifiers changed from: protected */
    public final void f(Object obj) {
        if (!(d() == null)) {
            super.f(obj);
        } else if (obj != null) {
            J.a(this.f29103h, obj);
        }
    }

    public final Object getRawResult() {
        return c();
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.f29104i = true;
    }

    /* access modifiers changed from: protected */
    public final void i() {
        C0209d dVar = this;
        for (C0209d dVar2 = (C0209d) d(); dVar2 != null; dVar2 = (C0209d) dVar2.d()) {
            if (dVar2.f29140d == dVar) {
                C0209d dVar3 = (C0209d) dVar2.f29141e;
                if (!dVar3.f29104i) {
                    dVar3.h();
                }
            }
            dVar = dVar2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object j();
}
