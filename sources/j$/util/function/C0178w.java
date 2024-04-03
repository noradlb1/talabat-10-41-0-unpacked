package j$.util.function;

import java.util.function.DoubleToLongFunction;

/* renamed from: j$.util.function.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0178w implements C0180y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleToLongFunction f28868a;

    private /* synthetic */ C0178w(DoubleToLongFunction doubleToLongFunction) {
        this.f28868a = doubleToLongFunction;
    }

    public static /* synthetic */ C0180y b(DoubleToLongFunction doubleToLongFunction) {
        if (doubleToLongFunction == null) {
            return null;
        }
        return doubleToLongFunction instanceof C0179x ? ((C0179x) doubleToLongFunction).f28870a : new C0178w(doubleToLongFunction);
    }

    public final /* synthetic */ long a(double d11) {
        return this.f28868a.applyAsLong(d11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0178w) {
            obj = ((C0178w) obj).f28868a;
        }
        return this.f28868a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28868a.hashCode();
    }
}
