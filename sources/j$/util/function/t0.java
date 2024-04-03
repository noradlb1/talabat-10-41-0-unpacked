package j$.util.function;

import java.util.function.LongUnaryOperator;

public final /* synthetic */ class t0 implements LongUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f28865a;

    private /* synthetic */ t0(u0 u0Var) {
        this.f28865a = u0Var;
    }

    public static /* synthetic */ LongUnaryOperator a(u0 u0Var) {
        if (u0Var == null) {
            return null;
        }
        return u0Var instanceof s0 ? ((s0) u0Var).f28863a : new t0(u0Var);
    }

    public final /* synthetic */ LongUnaryOperator andThen(LongUnaryOperator longUnaryOperator) {
        return a(((s0) this.f28865a).a(s0.d(longUnaryOperator)));
    }

    public final /* synthetic */ long applyAsLong(long j11) {
        return ((s0) this.f28865a).b(j11);
    }

    public final /* synthetic */ LongUnaryOperator compose(LongUnaryOperator longUnaryOperator) {
        return a(((s0) this.f28865a).c(s0.d(longUnaryOperator)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        u0 u0Var = this.f28865a;
        if (obj instanceof t0) {
            obj = ((t0) obj).f28865a;
        }
        return u0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28865a.hashCode();
    }
}
