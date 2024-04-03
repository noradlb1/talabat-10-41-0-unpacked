package j$.util.stream;

import j$.util.C0189n;
import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.x3  reason: case insensitive filesystem */
final class C0312x3 extends C0223f3 implements G {
    C0312x3(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        super(y0Var, spliterator, z11);
    }

    C0312x3(C0314y0 y0Var, C0194a aVar, boolean z11) {
        super(y0Var, aVar, z11);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    /* renamed from: b */
    public final void forEachRemaining(C0152f0 f0Var) {
        if (this.f29150h != null || this.f29151i) {
            do {
            } while (tryAdvance(f0Var));
            return;
        }
        Objects.requireNonNull(f0Var);
        h();
        C0307w3 w3Var = new C0307w3(f0Var, 1);
        this.f29144b.g1(this.f29146d, w3Var);
        this.f29151i = true;
    }

    /* renamed from: e */
    public final boolean tryAdvance(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        boolean f11 = f();
        if (f11) {
            W2 w22 = (W2) this.f29150h;
            long j11 = this.f29149g;
            int t11 = w22.t(j11);
            f0Var.accept((w22.f29133c == 0 && t11 == 0) ? ((long[]) w22.f29070e)[(int) j11] : ((long[][]) w22.f29071f)[t11][(int) (j11 - w22.f29134d[t11])]);
        }
        return f11;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        W2 w22 = new W2();
        this.f29150h = w22;
        this.f29147e = this.f29144b.h1(new C0307w3(w22, 0));
        this.f29148f = new C0194a(8, this);
    }

    /* access modifiers changed from: package-private */
    public final C0223f3 k(Spliterator spliterator) {
        return new C0312x3(this.f29144b, spliterator, this.f29143a);
    }

    public final G trySplit() {
        return (G) super.trySplit();
    }
}
