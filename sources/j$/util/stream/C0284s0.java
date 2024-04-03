package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.C0160j0;
import j$.util.function.C0164l0;
import java.util.Objects;

/* renamed from: j$.util.stream.s0  reason: case insensitive filesystem */
final class C0284s0 extends C0294u0 implements C0267o2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0299v0 f29218c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0164l0 f29219d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0284s0(C0164l0 l0Var, C0299v0 v0Var) {
        super(v0Var);
        this.f29218c = v0Var;
        this.f29219d = l0Var;
    }

    public final void accept(long j11) {
        if (!this.f29240a) {
            boolean e11 = ((C0160j0) this.f29219d).e(j11);
            C0299v0 v0Var = this.f29218c;
            if (e11 == v0Var.f29250a) {
                this.f29240a = true;
                this.f29241b = v0Var.f29251b;
            }
        }
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
