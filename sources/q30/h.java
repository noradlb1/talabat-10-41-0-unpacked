package q30;

import j$.util.function.Function;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class h implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SelectorResolver f28161a;

    public /* synthetic */ h(SelectorResolver selectorResolver) {
        this.f28161a = selectorResolver;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return EngineDiscoveryRequestResolver.Builder.lambda$addSelectorResolver$1(this.f28161a, (EngineDiscoveryRequestResolver.InitializationContext) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
