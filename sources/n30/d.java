package n30;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.DiscoverySelectors;

public final /* synthetic */ class d implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DiscoverySelectors.selectModule((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
