package j$.util.stream;

import j$.util.C0186k;
import j$.util.function.H;
import java.util.Objects;

final class K extends N implements C0262n2 {

    /* renamed from: c  reason: collision with root package name */
    static final I f28956c;

    /* renamed from: d  reason: collision with root package name */
    static final I f28957d;

    static {
        C0218e3 e3Var = C0218e3.INT_VALUE;
        f28956c = new I(true, e3Var, C0186k.a(), new N0(26), new C0199b(13));
        f28957d = new I(false, e3Var, C0186k.a(), new N0(26), new C0199b(13));
    }

    K() {
    }

    public final void accept(int i11) {
        p((Object) Integer.valueOf(i11));
    }

    public final Object get() {
        if (this.f28982a) {
            return C0186k.d(((Integer) this.f28983b).intValue());
        }
        return null;
    }

    public final j$.util.function.K n(j$.util.function.K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
