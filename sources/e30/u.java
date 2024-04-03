package e30;

import j$.util.function.Function;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class u implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((SelectorResolver.Match) obj).getTestDescriptor();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
