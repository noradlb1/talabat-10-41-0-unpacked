package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class f2 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ReflectionUtils.getMethods((Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
