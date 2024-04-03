package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.J;
import java.util.concurrent.CountedCompleter;

final class O extends C0209d {

    /* renamed from: j  reason: collision with root package name */
    private final I f28994j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f28995k;

    O(I i11, boolean z11, C0314y0 y0Var, Spliterator spliterator) {
        super(y0Var, spliterator);
        this.f28995k = z11;
        this.f28994j = i11;
    }

    O(O o11, Spliterator spliterator) {
        super((C0209d) o11, spliterator);
        this.f28995k = o11.f28995k;
        this.f28994j = o11.f28994j;
    }

    /* access modifiers changed from: protected */
    public final Object a() {
        boolean z11;
        C0314y0 y0Var = this.f29137a;
        V3 v32 = (V3) this.f28994j.f28938d.get();
        y0Var.g1(this.f29138b, v32);
        Object obj = v32.get();
        if (!this.f28995k) {
            if (obj != null) {
                J.a(this.f29103h, obj);
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            C0219f fVar = this;
            while (true) {
                if (fVar != null) {
                    C0219f d11 = fVar.d();
                    if (d11 != null && d11.f29140d != fVar) {
                        z11 = false;
                        break;
                    }
                    fVar = d11;
                } else {
                    z11 = true;
                    break;
                }
            }
            if (z11) {
                J.a(this.f29103h, obj);
            } else {
                i();
            }
            return obj;
        }
    }

    /* access modifiers changed from: protected */
    public final C0219f e(Spliterator spliterator) {
        return new O(this, spliterator);
    }

    /* access modifiers changed from: protected */
    public final Object j() {
        return this.f28994j.f28936b;
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        boolean z11;
        if (this.f28995k) {
            O o11 = (O) this.f29140d;
            O o12 = null;
            while (true) {
                if (o11 == o12) {
                    break;
                }
                Object c11 = o11.c();
                if (c11 == null || !this.f28994j.f28937c.test(c11)) {
                    o12 = o11;
                    o11 = (O) this.f29141e;
                } else {
                    f(c11);
                    C0219f fVar = this;
                    while (true) {
                        if (fVar != null) {
                            C0219f d11 = fVar.d();
                            if (d11 != null && d11.f29140d != fVar) {
                                z11 = false;
                                break;
                            }
                            fVar = d11;
                        } else {
                            z11 = true;
                            break;
                        }
                    }
                    if (z11) {
                        J.a(this.f29103h, c11);
                    } else {
                        i();
                    }
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
