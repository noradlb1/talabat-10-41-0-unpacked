package j$.util.stream;

import j$.util.A;
import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

final class H3 extends K3 implements A, C0165m {

    /* renamed from: f  reason: collision with root package name */
    double f28934f;

    H3(A a11, long j11, long j12) {
        super(a11, j11, j12);
    }

    H3(A a11, H3 h32) {
        super(a11, h32);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    public final void accept(double d11) {
        this.f28934f = d11;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    /* access modifiers changed from: protected */
    public final Spliterator r(Spliterator spliterator) {
        return new H3((A) spliterator, this);
    }

    /* access modifiers changed from: protected */
    public final void t(Object obj) {
        ((C0165m) obj).accept(this.f28934f);
    }

    /* access modifiers changed from: protected */
    public final C0243j3 u(int i11) {
        return new C0228g3(i11);
    }
}
