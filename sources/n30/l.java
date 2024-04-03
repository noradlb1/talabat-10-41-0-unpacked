package n30;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.MethodSelector;

public final /* synthetic */ class l implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelector f26902a;

    public /* synthetic */ l(MethodSelector methodSelector) {
        this.f26902a = methodSelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f26902a.lambda$lazyLoadJavaClass$0((Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
