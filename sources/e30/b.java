package e30;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f61966a;

    public /* synthetic */ b(Class cls) {
        this.f61966a = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return (TestDescriptor) this.f61966a.cast((TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
