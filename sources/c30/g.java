package c30;

import j$.util.function.Function;
import org.junit.jupiter.engine.config.CachingJupiterConfiguration;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CachingJupiterConfiguration f58198a;

    public /* synthetic */ g(CachingJupiterConfiguration cachingJupiterConfiguration) {
        this.f58198a = cachingJupiterConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f58198a.lambda$getDefaultTestClassOrderer$8((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
