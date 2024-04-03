package j$.util.stream;

import j$.util.C0185j;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

final class J extends N implements C0257m2 {

    /* renamed from: c  reason: collision with root package name */
    static final I f28946c;

    /* renamed from: d  reason: collision with root package name */
    static final I f28947d;

    static {
        C0218e3 e3Var = C0218e3.DOUBLE_VALUE;
        f28946c = new I(true, e3Var, C0185j.a(), new N0(25), new C0199b(12));
        f28947d = new I(false, e3Var, C0185j.a(), new N0(25), new C0199b(12));
    }

    J() {
    }

    public final void accept(double d11) {
        p((Object) Double.valueOf(d11));
    }

    public final Object get() {
        if (this.f28982a) {
            return C0185j.d(((Double) this.f28983b).doubleValue());
        }
        return null;
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }
}
