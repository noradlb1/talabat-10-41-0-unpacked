package e30;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Supplier;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class w implements BiFunction {
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return SelectorResolver.Match.exact((TestDescriptor) obj, (Supplier) obj2);
    }
}
