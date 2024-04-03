package j$.util.function;

import java.util.function.DoubleToIntFunction;

/* renamed from: j$.util.function.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0175t implements C0177v {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleToIntFunction f28864a;

    private /* synthetic */ C0175t(DoubleToIntFunction doubleToIntFunction) {
        this.f28864a = doubleToIntFunction;
    }

    public static /* synthetic */ C0177v b(DoubleToIntFunction doubleToIntFunction) {
        if (doubleToIntFunction == null) {
            return null;
        }
        return doubleToIntFunction instanceof C0176u ? ((C0176u) doubleToIntFunction).f28866a : new C0175t(doubleToIntFunction);
    }

    public final /* synthetic */ int a(double d11) {
        return this.f28864a.applyAsInt(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0175t) {
            obj = ((C0175t) obj).f28864a;
        }
        return this.f28864a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28864a.hashCode();
    }
}
