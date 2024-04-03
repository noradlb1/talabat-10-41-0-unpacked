package z20;

import j$.util.function.Function;
import org.junit.platform.commons.support.ReflectionSupport;

public final /* synthetic */ class c implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ReflectionSupport.newInstance((Class) obj, new Object[0]);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
