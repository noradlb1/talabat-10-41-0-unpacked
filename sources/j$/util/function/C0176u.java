package j$.util.function;

import java.util.function.DoubleToIntFunction;

/* renamed from: j$.util.function.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0176u implements DoubleToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0177v f28866a;

    private /* synthetic */ C0176u(C0177v vVar) {
        this.f28866a = vVar;
    }

    public static /* synthetic */ DoubleToIntFunction a(C0177v vVar) {
        if (vVar == null) {
            return null;
        }
        return vVar instanceof C0175t ? ((C0175t) vVar).f28864a : new C0176u(vVar);
    }

    public final /* synthetic */ int applyAsInt(double d11) {
        return ((C0175t) this.f28866a).a(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0177v vVar = this.f28866a;
        if (obj instanceof C0176u) {
            obj = ((C0176u) obj).f28866a;
        }
        return vVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28866a.hashCode();
    }
}
