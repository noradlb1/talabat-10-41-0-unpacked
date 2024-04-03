package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Supplier;
import java.util.Comparator;

/* renamed from: j$.util.stream.f3  reason: case insensitive filesystem */
abstract class C0223f3 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    final boolean f29143a;

    /* renamed from: b  reason: collision with root package name */
    final C0314y0 f29144b;

    /* renamed from: c  reason: collision with root package name */
    private Supplier f29145c;

    /* renamed from: d  reason: collision with root package name */
    Spliterator f29146d;

    /* renamed from: e  reason: collision with root package name */
    C0272p2 f29147e;

    /* renamed from: f  reason: collision with root package name */
    C0194a f29148f;

    /* renamed from: g  reason: collision with root package name */
    long f29149g;

    /* renamed from: h  reason: collision with root package name */
    C0214e f29150h;

    /* renamed from: i  reason: collision with root package name */
    boolean f29151i;

    C0223f3(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        this.f29144b = y0Var;
        this.f29145c = null;
        this.f29146d = spliterator;
        this.f29143a = z11;
    }

    C0223f3(C0314y0 y0Var, C0194a aVar, boolean z11) {
        this.f29144b = y0Var;
        this.f29145c = aVar;
        this.f29146d = null;
        this.f29143a = z11;
    }

    private boolean g() {
        while (this.f29150h.count() == 0) {
            if (this.f29147e.h() || !this.f29148f.getAsBoolean()) {
                if (this.f29151i) {
                    return false;
                }
                this.f29147e.end();
                this.f29151i = true;
            }
        }
        return true;
    }

    public final int characteristics() {
        h();
        int B = C0213d3.B(this.f29144b.T0()) & C0213d3.f29109f;
        return (B & 64) != 0 ? (B & -16449) | (this.f29146d.characteristics() & 16448) : B;
    }

    public final long estimateSize() {
        h();
        return this.f29146d.estimateSize();
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        C0214e eVar = this.f29150h;
        boolean z11 = false;
        if (eVar != null) {
            long j11 = this.f29149g + 1;
            this.f29149g = j11;
            if (j11 < eVar.count()) {
                z11 = true;
            }
            if (z11) {
                return z11;
            }
            this.f29149g = 0;
            this.f29150h.clear();
            return g();
        } else if (this.f29151i) {
            return false;
        } else {
            h();
            i();
            this.f29149g = 0;
            this.f29147e.f(this.f29146d.getExactSizeIfKnown());
            return g();
        }
    }

    public final Comparator getComparator() {
        if (C0189n.k(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final long getExactSizeIfKnown() {
        h();
        if (C0213d3.SIZED.k(this.f29144b.T0())) {
            return this.f29146d.getExactSizeIfKnown();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        if (this.f29146d == null) {
            this.f29146d = (Spliterator) this.f29145c.get();
            this.f29145c = null;
        }
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* access modifiers changed from: package-private */
    public abstract void i();

    /* access modifiers changed from: package-private */
    public abstract C0223f3 k(Spliterator spliterator);

    public final String toString() {
        return String.format("%s[%s]", new Object[]{getClass().getName(), this.f29146d});
    }

    public Spliterator trySplit() {
        if (!this.f29143a || this.f29150h != null || this.f29151i) {
            return null;
        }
        h();
        Spliterator trySplit = this.f29146d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return k(trySplit);
    }
}
