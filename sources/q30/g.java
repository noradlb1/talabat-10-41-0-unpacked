package q30;

import j$.util.function.Function;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolver.InitializationContext f28160a;

    public /* synthetic */ g(EngineDiscoveryRequestResolver.InitializationContext initializationContext) {
        this.f28160a = initializationContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((Function) obj).apply(this.f28160a);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
