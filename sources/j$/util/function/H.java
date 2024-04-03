package j$.util.function;

import java.util.Objects;

public final /* synthetic */ class H implements K {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ K f28801a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K f28802b;

    public /* synthetic */ H(K k11, K k12) {
        this.f28801a = k11;
        this.f28802b = k12;
    }

    public final void accept(int i11) {
        this.f28801a.accept(i11);
        this.f28802b.accept(i11);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
