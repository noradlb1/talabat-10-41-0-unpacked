package p30;

import j$.util.function.Function;
import org.junit.platform.engine.support.descriptor.ClassSource;

public final /* synthetic */ class d implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSource f28147a;

    public /* synthetic */ d(ClassSource classSource) {
        this.f28147a = classSource;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28147a.lambda$getJavaClass$1((Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
