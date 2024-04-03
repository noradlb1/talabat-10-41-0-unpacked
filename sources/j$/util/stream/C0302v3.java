package j$.util.stream;

import j$.util.C0189n;
import j$.util.D;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.stream.v3  reason: case insensitive filesystem */
final class C0302v3 extends C0223f3 implements D {
    C0302v3(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        super(y0Var, spliterator, z11);
    }

    C0302v3(C0314y0 y0Var, C0194a aVar, boolean z11) {
        super(y0Var, aVar, z11);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    /* renamed from: c */
    public final void forEachRemaining(K k11) {
        if (this.f29150h != null || this.f29151i) {
            do {
            } while (tryAdvance(k11));
            return;
        }
        Objects.requireNonNull(k11);
        h();
        C0297u3 u3Var = new C0297u3(k11, 1);
        this.f29144b.g1(this.f29146d, u3Var);
        this.f29151i = true;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        U2 u22 = new U2();
        this.f29150h = u22;
        this.f29147e = this.f29144b.h1(new C0297u3(u22, 0));
        this.f29148f = new C0194a(7, this);
    }

    /* renamed from: j */
    public final boolean tryAdvance(K k11) {
        Objects.requireNonNull(k11);
        boolean f11 = f();
        if (f11) {
            U2 u22 = (U2) this.f29150h;
            long j11 = this.f29149g;
            int t11 = u22.t(j11);
            k11.accept((u22.f29133c == 0 && t11 == 0) ? ((int[]) u22.f29070e)[(int) j11] : ((int[][]) u22.f29071f)[t11][(int) (j11 - u22.f29134d[t11])]);
        }
        return f11;
    }

    /* access modifiers changed from: package-private */
    public final C0223f3 k(Spliterator spliterator) {
        return new C0302v3(this.f29144b, spliterator, this.f29143a);
    }

    public final D trySplit() {
        return (D) super.trySplit();
    }
}
