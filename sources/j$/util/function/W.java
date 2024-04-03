package j$.util.function;

import java.util.function.IntUnaryOperator;

public final /* synthetic */ class W implements Y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntUnaryOperator f28827a;

    private /* synthetic */ W(IntUnaryOperator intUnaryOperator) {
        this.f28827a = intUnaryOperator;
    }

    public static /* synthetic */ Y d(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return intUnaryOperator instanceof X ? ((X) intUnaryOperator).f28828a : new W(intUnaryOperator);
    }

    public final /* synthetic */ Y a(Y y11) {
        return d(this.f28827a.andThen(X.a(y11)));
    }

    public final /* synthetic */ int b(int i11) {
        return this.f28827a.applyAsInt(i11);
    }

    public final /* synthetic */ Y c(Y y11) {
        return d(this.f28827a.compose(X.a(y11)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof W) {
            obj = ((W) obj).f28827a;
        }
        return this.f28827a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28827a.hashCode();
    }
}
