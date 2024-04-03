package l30;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class q0 implements BiFunction {
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return ReflectionUtils.tryToLoadClass((String) obj, (ClassLoader) obj2);
    }
}
