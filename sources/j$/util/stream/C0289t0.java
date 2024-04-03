package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.C0173q;
import j$.util.function.C0174s;
import java.util.Objects;

/* renamed from: j$.util.stream.t0  reason: case insensitive filesystem */
final class C0289t0 extends C0294u0 implements C0257m2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0299v0 f29228c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0174s f29229d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0289t0(C0174s sVar, C0299v0 v0Var) {
        super(v0Var);
        this.f29228c = v0Var;
        this.f29229d = sVar;
    }

    public final void accept(double d11) {
        if (!this.f29240a) {
            boolean e11 = ((C0173q) this.f29229d).e(d11);
            C0299v0 v0Var = this.f29228c;
            if (e11 == v0Var.f29250a) {
                this.f29240a = true;
                this.f29241b = v0Var.f29251b;
            }
        }
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
