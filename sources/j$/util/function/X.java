package j$.util.function;

import java.util.function.IntUnaryOperator;

public final /* synthetic */ class X implements IntUnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y f28828a;

    private /* synthetic */ X(Y y11) {
        this.f28828a = y11;
    }

    public static /* synthetic */ IntUnaryOperator a(Y y11) {
        if (y11 == null) {
            return null;
        }
        return y11 instanceof W ? ((W) y11).f28827a : new X(y11);
    }

    public final /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        return a(((W) this.f28828a).a(W.d(intUnaryOperator)));
    }

    public final /* synthetic */ int applyAsInt(int i11) {
        return ((W) this.f28828a).b(i11);
    }

    public final /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        return a(((W) this.f28828a).c(W.d(intUnaryOperator)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Y y11 = this.f28828a;
        if (obj instanceof X) {
            obj = ((X) obj).f28828a;
        }
        return y11.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28828a.hashCode();
    }
}
