package j$.util;

import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0192q implements K {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f28886a;

    public /* synthetic */ C0192q(Consumer consumer) {
        this.f28886a = consumer;
    }

    public final void accept(int i11) {
        this.f28886a.accept(Integer.valueOf(i11));
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
