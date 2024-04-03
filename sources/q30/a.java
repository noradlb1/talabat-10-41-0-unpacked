package q30;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.DiscoverySelectors;

public final /* synthetic */ class a implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DiscoverySelectors.selectClass((Class<?>) (Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
