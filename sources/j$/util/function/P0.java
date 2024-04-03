package j$.util.function;

import j$.util.function.Function;
import j$.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public final /* synthetic */ class P0 implements UnaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnaryOperator f28818a;

    private /* synthetic */ P0(UnaryOperator unaryOperator) {
        this.f28818a = unaryOperator;
    }

    public static /* synthetic */ UnaryOperator a(UnaryOperator unaryOperator) {
        if (unaryOperator == null) {
            return null;
        }
        return unaryOperator instanceof UnaryOperator.VivifiedWrapper ? ((UnaryOperator.VivifiedWrapper) unaryOperator).f28826a : new P0(unaryOperator);
    }

    public final /* synthetic */ Function andThen(Function function) {
        return D.a(this.f28818a.andThen(Function.VivifiedWrapper.convert(function)));
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.f28818a.apply(obj);
    }

    public final /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
        return D.a(this.f28818a.compose(Function.VivifiedWrapper.convert(function)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        UnaryOperator unaryOperator = this.f28818a;
        if (obj instanceof P0) {
            obj = ((P0) obj).f28818a;
        }
        return unaryOperator.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28818a.hashCode();
    }
}
