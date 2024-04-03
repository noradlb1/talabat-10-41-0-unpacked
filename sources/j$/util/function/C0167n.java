package j$.util.function;

import java.util.function.DoubleFunction;

/* renamed from: j$.util.function.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0167n implements C0171p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleFunction f28856a;

    private /* synthetic */ C0167n(DoubleFunction doubleFunction) {
        this.f28856a = doubleFunction;
    }

    public static /* synthetic */ C0171p a(DoubleFunction doubleFunction) {
        if (doubleFunction == null) {
            return null;
        }
        return doubleFunction instanceof C0169o ? ((C0169o) doubleFunction).f28858a : new C0167n(doubleFunction);
    }

    public final /* synthetic */ Object apply(double d11) {
        return this.f28856a.apply(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0167n) {
            obj = ((C0167n) obj).f28856a;
        }
        return this.f28856a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28856a.hashCode();
    }
}
