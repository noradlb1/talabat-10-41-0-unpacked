package j$.util.stream;

import j$.util.A;
import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.t3  reason: case insensitive filesystem */
final class C0292t3 extends C0223f3 implements A {
    C0292t3(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        super(y0Var, spliterator, z11);
    }

    C0292t3(C0314y0 y0Var, C0194a aVar, boolean z11) {
        super(y0Var, aVar, z11);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    /* renamed from: d */
    public final void forEachRemaining(C0165m mVar) {
        if (this.f29150h != null || this.f29151i) {
            do {
            } while (tryAdvance(mVar));
            return;
        }
        Objects.requireNonNull(mVar);
        h();
        C0287s3 s3Var = new C0287s3(mVar, 1);
        this.f29144b.g1(this.f29146d, s3Var);
        this.f29151i = true;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        S2 s22 = new S2();
        this.f29150h = s22;
        this.f29147e = this.f29144b.h1(new C0287s3(s22, 0));
        this.f29148f = new C0194a(6, this);
    }

    /* access modifiers changed from: package-private */
    public final C0223f3 k(Spliterator spliterator) {
        return new C0292t3(this.f29144b, spliterator, this.f29143a);
    }

    /* renamed from: o */
    public final boolean tryAdvance(C0165m mVar) {
        Objects.requireNonNull(mVar);
        boolean f11 = f();
        if (f11) {
            S2 s22 = (S2) this.f29150h;
            long j11 = this.f29149g;
            int t11 = s22.t(j11);
            mVar.accept((s22.f29133c == 0 && t11 == 0) ? ((double[]) s22.f29070e)[(int) j11] : ((double[][]) s22.f29071f)[t11][(int) (j11 - s22.f29134d[t11])]);
        }
        return f11;
    }

    public final A trySplit() {
        return (A) super.trySplit();
    }
}
