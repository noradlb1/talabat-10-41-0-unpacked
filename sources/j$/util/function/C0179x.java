package j$.util.function;

import java.util.function.DoubleToLongFunction;

/* renamed from: j$.util.function.x  reason: case insensitive filesystem */
public final /* synthetic */ class C0179x implements DoubleToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0180y f28870a;

    private /* synthetic */ C0179x(C0180y yVar) {
        this.f28870a = yVar;
    }

    public static /* synthetic */ DoubleToLongFunction a(C0180y yVar) {
        if (yVar == null) {
            return null;
        }
        return yVar instanceof C0178w ? ((C0178w) yVar).f28868a : new C0179x(yVar);
    }

    public final /* synthetic */ long applyAsLong(double d11) {
        return ((C0178w) this.f28870a).a(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0180y yVar = this.f28870a;
        if (obj instanceof C0179x) {
            obj = ((C0179x) obj).f28870a;
        }
        return yVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28870a.hashCode();
    }
}
