package j$.util.function;

import j$.util.function.IntFunction;
import java.util.function.IntFunction;

public final /* synthetic */ class L implements IntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntFunction f28809a;

    private /* synthetic */ L(IntFunction intFunction) {
        this.f28809a = intFunction;
    }

    public static /* synthetic */ IntFunction a(IntFunction intFunction) {
        if (intFunction == null) {
            return null;
        }
        return intFunction instanceof IntFunction.VivifiedWrapper ? ((IntFunction.VivifiedWrapper) intFunction).f28806a : new L(intFunction);
    }

    public final /* synthetic */ Object apply(int i11) {
        return this.f28809a.apply(i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        IntFunction intFunction = this.f28809a;
        if (obj instanceof L) {
            obj = ((L) obj).f28809a;
        }
        return intFunction.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28809a.hashCode();
    }
}
