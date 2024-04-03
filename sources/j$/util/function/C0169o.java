package j$.util.function;

import java.util.function.DoubleFunction;

/* renamed from: j$.util.function.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0169o implements DoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0171p f28858a;

    private /* synthetic */ C0169o(C0171p pVar) {
        this.f28858a = pVar;
    }

    public static /* synthetic */ DoubleFunction a(C0171p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar instanceof C0167n ? ((C0167n) pVar).f28856a : new C0169o(pVar);
    }

    public final /* synthetic */ Object apply(double d11) {
        return this.f28858a.apply(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0171p pVar = this.f28858a;
        if (obj instanceof C0169o) {
            obj = ((C0169o) obj).f28858a;
        }
        return pVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28858a.hashCode();
    }
}
