package e30;

import j$.util.function.Function;
import org.junit.jupiter.engine.discovery.DiscoverySelectorResolver;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;

public final /* synthetic */ class m implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DiscoverySelectorResolver.lambda$static$2((EngineDiscoveryRequestResolver.InitializationContext) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
