package j$.util.function;

import java.util.function.DoubleUnaryOperator;

public final /* synthetic */ class A implements DoubleUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B f28782a;

    private /* synthetic */ A(B b11) {
        this.f28782a = b11;
    }

    public static /* synthetic */ DoubleUnaryOperator a(B b11) {
        if (b11 == null) {
            return null;
        }
        return b11 instanceof C0181z ? ((C0181z) b11).f28872a : new A(b11);
    }

    public final /* synthetic */ DoubleUnaryOperator andThen(DoubleUnaryOperator doubleUnaryOperator) {
        return a(((C0181z) this.f28782a).a(C0181z.d(doubleUnaryOperator)));
    }

    public final /* synthetic */ double applyAsDouble(double d11) {
        return ((C0181z) this.f28782a).b(d11);
    }

    public final /* synthetic */ DoubleUnaryOperator compose(DoubleUnaryOperator doubleUnaryOperator) {
        return a(((C0181z) this.f28782a).c(C0181z.d(doubleUnaryOperator)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        B b11 = this.f28782a;
        if (obj instanceof A) {
            obj = ((A) obj).f28782a;
        }
        return b11.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28782a.hashCode();
    }
}
