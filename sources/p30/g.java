package p30;

import j$.util.function.Function;
import org.junit.platform.engine.support.descriptor.MethodSource;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSource f28150a;

    public /* synthetic */ g(MethodSource methodSource) {
        this.f28150a = methodSource;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28150a.lambda$lazyLoadJavaClass$0((Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
