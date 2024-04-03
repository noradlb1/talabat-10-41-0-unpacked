package j$.util.stream;

import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

public final /* synthetic */ class Y implements K {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0272p2 f29068a;

    public /* synthetic */ Y(C0272p2 p2Var) {
        this.f29068a = p2Var;
    }

    public final void accept(int i11) {
        this.f29068a.accept(i11);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
