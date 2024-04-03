package j$.util.function;

import java.util.function.DoubleBinaryOperator;

/* renamed from: j$.util.function.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0155h implements DoubleBinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0157i f28847a;

    private /* synthetic */ C0155h(C0157i iVar) {
        this.f28847a = iVar;
    }

    public static /* synthetic */ DoubleBinaryOperator a(C0157i iVar) {
        if (iVar == null) {
            return null;
        }
        return iVar instanceof C0153g ? ((C0153g) iVar).f28845a : new C0155h(iVar);
    }

    public final /* synthetic */ double applyAsDouble(double d11, double d12) {
        return this.f28847a.applyAsDouble(d11, d12);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0157i iVar = this.f28847a;
        if (obj instanceof C0155h) {
            obj = ((C0155h) obj).f28847a;
        }
        return iVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28847a.hashCode();
    }
}
