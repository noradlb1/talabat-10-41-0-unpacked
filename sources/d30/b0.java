package d30;

import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class b0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61829a;

    public /* synthetic */ b0(ClassBasedTestDescriptor classBasedTestDescriptor) {
        this.f61829a = classBasedTestDescriptor;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f61829a.synthesizeAfterEachMethodAdapter((Method) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
