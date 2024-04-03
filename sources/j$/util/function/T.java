package j$.util.function;

import java.util.function.IntToLongFunction;

public final /* synthetic */ class T implements V {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntToLongFunction f28821a;

    private /* synthetic */ T(IntToLongFunction intToLongFunction) {
        this.f28821a = intToLongFunction;
    }

    public static /* synthetic */ V b(IntToLongFunction intToLongFunction) {
        if (intToLongFunction == null) {
            return null;
        }
        return intToLongFunction instanceof U ? ((U) intToLongFunction).f28825a : new T(intToLongFunction);
    }

    public final /* synthetic */ long a(int i11) {
        return this.f28821a.applyAsLong(i11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof T) {
            obj = ((T) obj).f28821a;
        }
        return this.f28821a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28821a.hashCode();
    }
}
