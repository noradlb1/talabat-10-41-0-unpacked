package j$.util.stream;

import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

public final /* synthetic */ class A3 implements K {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28895a;

    public /* synthetic */ A3(int i11) {
        this.f28895a = i11;
    }

    public final void accept(int i11) {
    }

    public final K n(K k11) {
        switch (this.f28895a) {
            case 0:
                Objects.requireNonNull(k11);
                return new H(this, k11);
            default:
                Objects.requireNonNull(k11);
                return new H(this, k11);
        }
    }
}
