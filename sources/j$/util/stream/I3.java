package j$.util.stream;

import j$.util.C0189n;
import j$.util.D;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

final class I3 extends K3 implements D, K {

    /* renamed from: f  reason: collision with root package name */
    int f28943f;

    I3(D d11, long j11, long j12) {
        super(d11, j11, j12);
    }

    I3(D d11, I3 i32) {
        super(d11, i32);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    public final void accept(int i11) {
        this.f28943f = i11;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }

    /* access modifiers changed from: protected */
    public final Spliterator r(Spliterator spliterator) {
        return new I3((D) spliterator, this);
    }

    /* access modifiers changed from: protected */
    public final void t(Object obj) {
        ((K) obj).accept(this.f28943f);
    }

    /* access modifiers changed from: protected */
    public final C0243j3 u(int i11) {
        return new C0233h3(i11);
    }
}
