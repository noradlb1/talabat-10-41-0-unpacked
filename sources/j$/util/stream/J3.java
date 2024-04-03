package j$.util.stream;

import j$.util.C0189n;
import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Objects;

final class J3 extends K3 implements G, C0152f0 {

    /* renamed from: f  reason: collision with root package name */
    long f28955f;

    J3(G g11, long j11, long j12) {
        super(g11, j11, j12);
    }

    J3(G g11, J3 j32) {
        super(g11, j32);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    public final void accept(long j11) {
        this.f28955f = j11;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    /* access modifiers changed from: protected */
    public final Spliterator r(Spliterator spliterator) {
        return new J3((G) spliterator, this);
    }

    /* access modifiers changed from: protected */
    public final void t(Object obj) {
        ((C0152f0) obj).accept(this.f28955f);
    }

    /* access modifiers changed from: protected */
    public final C0243j3 u(int i11) {
        return new C0238i3(i11);
    }
}
