package j$.util.function;

import java.util.function.DoubleUnaryOperator;

/* renamed from: j$.util.function.z  reason: case insensitive filesystem */
public final /* synthetic */ class C0181z implements B {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleUnaryOperator f28872a;

    private /* synthetic */ C0181z(DoubleUnaryOperator doubleUnaryOperator) {
        this.f28872a = doubleUnaryOperator;
    }

    public static /* synthetic */ B d(DoubleUnaryOperator doubleUnaryOperator) {
        if (doubleUnaryOperator == null) {
            return null;
        }
        return doubleUnaryOperator instanceof A ? ((A) doubleUnaryOperator).f28782a : new C0181z(doubleUnaryOperator);
    }

    public final /* synthetic */ B a(B b11) {
        return d(this.f28872a.andThen(A.a(b11)));
    }

    public final /* synthetic */ double b(double d11) {
        return this.f28872a.applyAsDouble(d11);
    }

    public final /* synthetic */ B c(B b11) {
        return d(this.f28872a.compose(A.a(b11)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0181z) {
            obj = ((C0181z) obj).f28872a;
        }
        return this.f28872a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28872a.hashCode();
    }
}
