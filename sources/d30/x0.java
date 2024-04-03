package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class x0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return JupiterTestDescriptor.lambda$getExclusiveResourcesFromAnnotation$2((ResourceLock) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
