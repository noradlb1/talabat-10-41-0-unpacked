package j$.util.function;

import j$.util.function.Function;
import java.util.function.Function;

public final /* synthetic */ class D implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f28793a;

    private /* synthetic */ D(Function function) {
        this.f28793a = function;
    }

    public static /* synthetic */ Function a(Function function) {
        if (function == null) {
            return null;
        }
        return function instanceof Function.VivifiedWrapper ? ((Function.VivifiedWrapper) function).f28799a : function instanceof UnaryOperator ? P0.a((UnaryOperator) function) : new D(function);
    }

    public final /* synthetic */ java.util.function.Function andThen(java.util.function.Function function) {
        return a(this.f28793a.andThen(Function.VivifiedWrapper.convert(function)));
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.f28793a.apply(obj);
    }

    public final /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
        return a(this.f28793a.compose(Function.VivifiedWrapper.convert(function)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Function function = this.f28793a;
        if (obj instanceof D) {
            obj = ((D) obj).f28793a;
        }
        return function.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28793a.hashCode();
    }
}
