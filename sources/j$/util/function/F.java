package j$.util.function;

import java.util.function.IntBinaryOperator;

public final /* synthetic */ class F implements IntBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ G f28795a;

    private /* synthetic */ F(G g11) {
        this.f28795a = g11;
    }

    public static /* synthetic */ IntBinaryOperator a(G g11) {
        if (g11 == null) {
            return null;
        }
        return g11 instanceof E ? ((E) g11).f28794a : new F(g11);
    }

    public final /* synthetic */ int applyAsInt(int i11, int i12) {
        return this.f28795a.applyAsInt(i11, i12);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        G g11 = this.f28795a;
        if (obj instanceof F) {
            obj = ((F) obj).f28795a;
        }
        return g11.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28795a.hashCode();
    }
}
