package d30;

import j$.util.function.Function;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor;

public final /* synthetic */ class z1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestTemplateTestDescriptor f61931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f61932b;

    public /* synthetic */ z1(TestTemplateTestDescriptor testTemplateTestDescriptor, AtomicInteger atomicInteger) {
        this.f61931a = testTemplateTestDescriptor;
        this.f61932b = atomicInteger;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f61931a.lambda$execute$1(this.f61932b, (TestTemplateInvocationContext) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
