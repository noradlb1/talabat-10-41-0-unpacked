package j$.util.function;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.util.function.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0153g implements C0157i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f28845a;

    private /* synthetic */ C0153g(DoubleBinaryOperator doubleBinaryOperator) {
        this.f28845a = doubleBinaryOperator;
    }

    public static /* synthetic */ C0157i a(DoubleBinaryOperator doubleBinaryOperator) {
        if (doubleBinaryOperator == null) {
            return null;
        }
        return doubleBinaryOperator instanceof C0155h ? ((C0155h) doubleBinaryOperator).f28847a : new C0153g(doubleBinaryOperator);
    }

    public final /* synthetic */ double applyAsDouble(double d11, double d12) {
        return this.f28845a.applyAsDouble(d11, d12);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0153g) {
            obj = ((C0153g) obj).f28845a;
        }
        return this.f28845a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28845a.hashCode();
    }
}
