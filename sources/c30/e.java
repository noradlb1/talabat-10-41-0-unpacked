package c30;

import j$.util.function.Function;
import org.junit.jupiter.engine.config.CachingJupiterConfiguration;

public final /* synthetic */ class e implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CachingJupiterConfiguration f58196a;

    public /* synthetic */ e(CachingJupiterConfiguration cachingJupiterConfiguration) {
        this.f58196a = cachingJupiterConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f58196a.lambda$getDefaultDisplayNameGenerator$6((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
