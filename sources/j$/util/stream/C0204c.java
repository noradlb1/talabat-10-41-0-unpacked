package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import java.util.Objects;

/* renamed from: j$.util.stream.c  reason: case insensitive filesystem */
abstract class C0204c extends C0314y0 implements BaseStream {

    /* renamed from: h  reason: collision with root package name */
    private final C0204c f29088h;

    /* renamed from: i  reason: collision with root package name */
    private final C0204c f29089i;

    /* renamed from: j  reason: collision with root package name */
    protected final int f29090j;

    /* renamed from: k  reason: collision with root package name */
    private C0204c f29091k;

    /* renamed from: l  reason: collision with root package name */
    private int f29092l;

    /* renamed from: m  reason: collision with root package name */
    private int f29093m;

    /* renamed from: n  reason: collision with root package name */
    private Spliterator f29094n;

    /* renamed from: o  reason: collision with root package name */
    private Supplier f29095o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29096p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f29097q;

    /* renamed from: r  reason: collision with root package name */
    private Runnable f29098r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f29099s;

    C0204c(Spliterator spliterator, int i11, boolean z11) {
        this.f29089i = null;
        this.f29094n = spliterator;
        this.f29088h = this;
        int i12 = C0213d3.f29110g & i11;
        this.f29090j = i12;
        this.f29093m = (~(i12 << 1)) & C0213d3.f29115l;
        this.f29092l = 0;
        this.f29099s = z11;
    }

    C0204c(Supplier supplier, int i11, boolean z11) {
        this.f29089i = null;
        this.f29095o = supplier;
        this.f29088h = this;
        int i12 = C0213d3.f29110g & i11;
        this.f29090j = i12;
        this.f29093m = (~(i12 << 1)) & C0213d3.f29115l;
        this.f29092l = 0;
        this.f29099s = z11;
    }

    C0204c(C0204c cVar, int i11) {
        if (!cVar.f29096p) {
            cVar.f29096p = true;
            cVar.f29091k = this;
            this.f29089i = cVar;
            this.f29090j = C0213d3.f29111h & i11;
            this.f29093m = C0213d3.f(i11, cVar.f29093m);
            C0204c cVar2 = cVar.f29088h;
            this.f29088h = cVar2;
            if (u1()) {
                cVar2.f29097q = true;
            }
            this.f29092l = cVar.f29092l + 1;
            return;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    private Spliterator w1(int i11) {
        int i12;
        int i13;
        C0204c cVar = this.f29088h;
        Spliterator spliterator = cVar.f29094n;
        if (spliterator != null) {
            cVar.f29094n = null;
        } else {
            Supplier supplier = cVar.f29095o;
            if (supplier != null) {
                spliterator = (Spliterator) supplier.get();
                cVar.f29095o = null;
            } else {
                throw new IllegalStateException("source already consumed or closed");
            }
        }
        if (cVar.f29099s && cVar.f29097q) {
            C0204c cVar2 = cVar.f29091k;
            int i14 = 1;
            while (cVar != this) {
                int i15 = cVar2.f29090j;
                if (cVar2.u1()) {
                    if (C0213d3.SHORT_CIRCUIT.k(i15)) {
                        i15 &= ~C0213d3.f29124u;
                    }
                    spliterator = cVar2.t1(cVar, spliterator);
                    if (spliterator.hasCharacteristics(64)) {
                        i13 = (~C0213d3.f29123t) & i15;
                        i12 = C0213d3.f29122s;
                    } else {
                        i13 = (~C0213d3.f29122s) & i15;
                        i12 = C0213d3.f29123t;
                    }
                    i15 = i12 | i13;
                    i14 = 0;
                }
                cVar2.f29092l = i14;
                cVar2.f29093m = C0213d3.f(i15, cVar.f29093m);
                i14++;
                C0204c cVar3 = cVar2;
                cVar2 = cVar2.f29091k;
                cVar = cVar3;
            }
        }
        if (i11 != 0) {
            this.f29093m = C0213d3.f(i11, this.f29093m);
        }
        return spliterator;
    }

    /* access modifiers changed from: package-private */
    public final void J0(Spliterator spliterator, C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        if (!C0213d3.SHORT_CIRCUIT.k(this.f29093m)) {
            p2Var.f(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(p2Var);
            p2Var.end();
            return;
        }
        K0(spliterator, p2Var);
    }

    /* access modifiers changed from: package-private */
    public final boolean K0(Spliterator spliterator, C0272p2 p2Var) {
        C0204c cVar = this;
        while (cVar.f29092l > 0) {
            cVar = cVar.f29089i;
        }
        p2Var.f(spliterator.getExactSizeIfKnown());
        boolean m12 = cVar.m1(spliterator, p2Var);
        p2Var.end();
        return m12;
    }

    /* access modifiers changed from: package-private */
    public final long N0(Spliterator spliterator) {
        if (C0213d3.SIZED.k(this.f29093m)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int T0() {
        return this.f29093m;
    }

    public final void close() {
        this.f29096p = true;
        this.f29095o = null;
        this.f29094n = null;
        C0204c cVar = this.f29088h;
        Runnable runnable = cVar.f29098r;
        if (runnable != null) {
            cVar.f29098r = null;
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 g1(Spliterator spliterator, C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        J0(spliterator, h1(p2Var));
        return p2Var;
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 h1(C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        C0204c cVar = this;
        while (cVar.f29092l > 0) {
            C0204c cVar2 = cVar.f29089i;
            p2Var = cVar.v1(cVar2.f29093m, p2Var);
            cVar = cVar2;
        }
        return p2Var;
    }

    /* access modifiers changed from: package-private */
    public final H0 i1(Spliterator spliterator, boolean z11, IntFunction intFunction) {
        if (this.f29088h.f29099s) {
            return l1(this, spliterator, z11, intFunction);
        }
        C0 c12 = c1(N0(spliterator), intFunction);
        g1(spliterator, c12);
        return c12.build();
    }

    public final boolean isParallel() {
        return this.f29088h.f29099s;
    }

    /* access modifiers changed from: package-private */
    public final Object j1(U3 u32) {
        if (!this.f29096p) {
            this.f29096p = true;
            return this.f29088h.f29099s ? u32.v(this, w1(u32.G())) : u32.b0(this, w1(u32.G()));
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* access modifiers changed from: package-private */
    public final H0 k1(IntFunction intFunction) {
        C0204c cVar;
        if (!this.f29096p) {
            this.f29096p = true;
            if (!this.f29088h.f29099s || (cVar = this.f29089i) == null || !u1()) {
                return i1(w1(0), true, intFunction);
            }
            this.f29092l = 0;
            return s1(cVar.w1(0), intFunction, cVar);
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* access modifiers changed from: package-private */
    public abstract H0 l1(C0314y0 y0Var, Spliterator spliterator, boolean z11, IntFunction intFunction);

    /* access modifiers changed from: package-private */
    public abstract boolean m1(Spliterator spliterator, C0272p2 p2Var);

    /* access modifiers changed from: package-private */
    public abstract C0218e3 n1();

    /* access modifiers changed from: package-private */
    public final C0218e3 o1() {
        C0204c cVar = this;
        while (cVar.f29092l > 0) {
            cVar = cVar.f29089i;
        }
        return cVar.n1();
    }

    public final BaseStream onClose(Runnable runnable) {
        if (!this.f29096p) {
            Objects.requireNonNull(runnable);
            C0204c cVar = this.f29088h;
            Runnable runnable2 = cVar.f29098r;
            if (runnable2 != null) {
                runnable = new Q3(0, runnable2, runnable);
            }
            cVar.f29098r = runnable;
            return this;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* access modifiers changed from: package-private */
    public final boolean p1() {
        return C0213d3.ORDERED.k(this.f29093m);
    }

    public final BaseStream parallel() {
        this.f29088h.f29099s = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Spliterator q1() {
        return w1(0);
    }

    /* access modifiers changed from: package-private */
    public abstract Spliterator r1(Supplier supplier);

    /* access modifiers changed from: package-private */
    public H0 s1(Spliterator spliterator, IntFunction intFunction, C0204c cVar) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public final BaseStream sequential() {
        this.f29088h.f29099s = false;
        return this;
    }

    public Spliterator spliterator() {
        if (!this.f29096p) {
            this.f29096p = true;
            C0204c cVar = this.f29088h;
            if (this != cVar) {
                return y1(this, new C0194a(1, this), cVar.f29099s);
            }
            Spliterator spliterator = cVar.f29094n;
            if (spliterator != null) {
                cVar.f29094n = null;
                return spliterator;
            }
            Supplier supplier = cVar.f29095o;
            if (supplier != null) {
                cVar.f29095o = null;
                return r1(supplier);
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* access modifiers changed from: package-private */
    public Spliterator t1(C0204c cVar, Spliterator spliterator) {
        return s1(spliterator, new C0199b(0), cVar).spliterator();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean u1();

    /* access modifiers changed from: package-private */
    public abstract C0272p2 v1(int i11, C0272p2 p2Var);

    /* access modifiers changed from: package-private */
    public final Spliterator x1() {
        C0204c cVar = this.f29088h;
        if (this != cVar) {
            throw new IllegalStateException();
        } else if (!this.f29096p) {
            this.f29096p = true;
            Spliterator spliterator = cVar.f29094n;
            if (spliterator != null) {
                cVar.f29094n = null;
                return spliterator;
            }
            Supplier supplier = cVar.f29095o;
            if (supplier != null) {
                Spliterator spliterator2 = (Spliterator) supplier.get();
                cVar.f29095o = null;
                return spliterator2;
            }
            throw new IllegalStateException("source already consumed or closed");
        } else {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Spliterator y1(C0314y0 y0Var, C0194a aVar, boolean z11);

    /* access modifiers changed from: package-private */
    public final Spliterator z1(Spliterator spliterator) {
        return this.f29092l == 0 ? spliterator : y1(this, new C0194a(0, spliterator), this.f29088h.f29099s);
    }
}
