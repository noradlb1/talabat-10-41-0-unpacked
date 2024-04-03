package m30;

import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Predicate;

public final /* synthetic */ class b implements BinaryOperator {
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Predicate) obj).and((Predicate) obj2);
    }
}
