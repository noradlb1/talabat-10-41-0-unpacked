package j$.util.function;

import java.util.function.LongUnaryOperator;

public final /* synthetic */ class s0 implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongUnaryOperator f28863a;

    private /* synthetic */ s0(LongUnaryOperator longUnaryOperator) {
        this.f28863a = longUnaryOperator;
    }

    public static /* synthetic */ u0 d(LongUnaryOperator longUnaryOperator) {
        if (longUnaryOperator == null) {
            return null;
        }
        return longUnaryOperator instanceof t0 ? ((t0) longUnaryOperator).f28865a : new s0(longUnaryOperator);
    }

    public final /* synthetic */ u0 a(u0 u0Var) {
        return d(this.f28863a.andThen(t0.a(u0Var)));
    }

    public final /* synthetic */ long b(long j11) {
        return this.f28863a.applyAsLong(j11);
    }

    public final /* synthetic */ u0 c(u0 u0Var) {
        return d(this.f28863a.compose(t0.a(u0Var)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof s0) {
            obj = ((s0) obj).f28863a;
        }
        return this.f28863a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28863a.hashCode();
    }
}
