package r30;

import j$.util.function.Function;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;

public final /* synthetic */ class i implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((ExclusiveResource) obj).getKey();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
