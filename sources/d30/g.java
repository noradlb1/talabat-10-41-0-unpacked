package d30;

import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61856a;

    public /* synthetic */ g(ClassBasedTestDescriptor classBasedTestDescriptor) {
        this.f61856a = classBasedTestDescriptor;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f61856a.synthesizeBeforeEachMethodAdapter((Method) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
