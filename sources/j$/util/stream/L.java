package j$.util.stream;

import j$.util.C0187l;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import java.util.Objects;

final class L extends N implements C0267o2 {

    /* renamed from: c  reason: collision with root package name */
    static final I f28965c;

    /* renamed from: d  reason: collision with root package name */
    static final I f28966d;

    static {
        C0218e3 e3Var = C0218e3.LONG_VALUE;
        f28965c = new I(true, e3Var, C0187l.a(), new N0(27), new C0199b(14));
        f28966d = new I(false, e3Var, C0187l.a(), new N0(27), new C0199b(14));
    }

    L() {
    }

    public final void accept(long j11) {
        p((Object) Long.valueOf(j11));
    }

    public final Object get() {
        if (this.f28982a) {
            return C0187l.d(((Long) this.f28983b).longValue());
        }
        return null;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }
}
