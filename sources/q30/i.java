package q30;

import j$.util.function.Function;
import j$.util.function.Predicate;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f28162a;

    public /* synthetic */ i(Predicate predicate) {
        this.f28162a = predicate;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return EngineDiscoveryRequestResolver.Builder.lambda$addClassContainerSelectorResolver$0(this.f28162a, (EngineDiscoveryRequestResolver.InitializationContext) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
