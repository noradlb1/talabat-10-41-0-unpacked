package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

final class P extends U implements C0257m2 {

    /* renamed from: b  reason: collision with root package name */
    final C0165m f29006b;

    P(C0165m mVar, boolean z11) {
        super(z11);
        this.f29006b = mVar;
    }

    public final void accept(double d11) {
        this.f29006b.accept(d11);
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        p((Double) obj);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }
}
