package g30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.Extension;

public final /* synthetic */ class f implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62082a;

    public /* synthetic */ f(Class cls) {
        this.f62082a = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return (Extension) this.f62082a.cast((Extension) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
