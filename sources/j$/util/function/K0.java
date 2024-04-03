package j$.util.function;

import j$.util.function.ToDoubleFunction;
import java.util.function.ToDoubleFunction;

public final /* synthetic */ class K0 implements ToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToDoubleFunction f28808a;

    private /* synthetic */ K0(ToDoubleFunction toDoubleFunction) {
        this.f28808a = toDoubleFunction;
    }

    public static /* synthetic */ ToDoubleFunction a(ToDoubleFunction toDoubleFunction) {
        if (toDoubleFunction == null) {
            return null;
        }
        return toDoubleFunction instanceof ToDoubleFunction.VivifiedWrapper ? ((ToDoubleFunction.VivifiedWrapper) toDoubleFunction).f28822a : new K0(toDoubleFunction);
    }

    public final /* synthetic */ double applyAsDouble(Object obj) {
        return this.f28808a.applyAsDouble(obj);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        ToDoubleFunction toDoubleFunction = this.f28808a;
        if (obj instanceof K0) {
            obj = ((K0) obj).f28808a;
        }
        return toDoubleFunction.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28808a.hashCode();
    }
}
