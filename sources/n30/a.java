package n30;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.ClassSelector;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelector f26898a;

    public /* synthetic */ a(ClassSelector classSelector) {
        this.f26898a = classSelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f26898a.lambda$getJavaClass$0((Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
