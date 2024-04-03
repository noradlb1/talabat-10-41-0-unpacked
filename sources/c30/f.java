package c30;

import j$.util.function.Function;
import org.junit.jupiter.engine.config.CachingJupiterConfiguration;

public final /* synthetic */ class f implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CachingJupiterConfiguration f58197a;

    public /* synthetic */ f(CachingJupiterConfiguration cachingJupiterConfiguration) {
        this.f58197a = cachingJupiterConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f58197a.lambda$getDefaultTestInstanceLifecycle$4((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
