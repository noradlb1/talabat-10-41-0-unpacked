package j$.util.function;

import j$.util.function.ToLongFunction;
import java.util.function.ToLongFunction;

public final /* synthetic */ class O0 implements ToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToLongFunction f28816a;

    private /* synthetic */ O0(ToLongFunction toLongFunction) {
        this.f28816a = toLongFunction;
    }

    public static /* synthetic */ ToLongFunction a(ToLongFunction toLongFunction) {
        if (toLongFunction == null) {
            return null;
        }
        return toLongFunction instanceof ToLongFunction.VivifiedWrapper ? ((ToLongFunction.VivifiedWrapper) toLongFunction).f28824a : new O0(toLongFunction);
    }

    public final /* synthetic */ long applyAsLong(Object obj) {
        return this.f28816a.applyAsLong(obj);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        ToLongFunction toLongFunction = this.f28816a;
        if (obj instanceof O0) {
            obj = ((O0) obj).f28816a;
        }
        return toLongFunction.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28816a.hashCode();
    }
}
