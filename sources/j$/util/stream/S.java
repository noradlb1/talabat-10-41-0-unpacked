package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import java.util.Objects;

final class S extends U implements C0267o2 {

    /* renamed from: b  reason: collision with root package name */
    final C0152f0 f29033b;

    S(C0152f0 f0Var, boolean z11) {
        super(z11);
        this.f29033b = f0Var;
    }

    public final void accept(long j11) {
        this.f29033b.accept(j11);
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }
}
