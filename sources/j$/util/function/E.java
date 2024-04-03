package j$.util.function;

import java.util.function.IntBinaryOperator;

public final /* synthetic */ class E implements G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntBinaryOperator f28794a;

    private /* synthetic */ E(IntBinaryOperator intBinaryOperator) {
        this.f28794a = intBinaryOperator;
    }

    public static /* synthetic */ G a(IntBinaryOperator intBinaryOperator) {
        if (intBinaryOperator == null) {
            return null;
        }
        return intBinaryOperator instanceof F ? ((F) intBinaryOperator).f28795a : new E(intBinaryOperator);
    }

    public final /* synthetic */ int applyAsInt(int i11, int i12) {
        return this.f28794a.applyAsInt(i11, i12);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof E) {
            obj = ((E) obj).f28794a;
        }
        return this.f28794a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28794a.hashCode();
    }
}
