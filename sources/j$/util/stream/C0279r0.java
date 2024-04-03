package j$.util.stream;

import j$.util.function.H;
import j$.util.function.IntPredicate;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.stream.r0  reason: case insensitive filesystem */
final class C0279r0 extends C0294u0 implements C0262n2 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0299v0 f29209c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ IntPredicate f29210d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0279r0(IntPredicate intPredicate, C0299v0 v0Var) {
        super(v0Var);
        this.f29209c = v0Var;
        this.f29210d = intPredicate;
    }

    public final void accept(int i11) {
        if (!this.f29240a) {
            boolean test = this.f29210d.test(i11);
            C0299v0 v0Var = this.f29209c;
            if (test == v0Var.f29250a) {
                this.f29240a = true;
                this.f29241b = v0Var.f29251b;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
