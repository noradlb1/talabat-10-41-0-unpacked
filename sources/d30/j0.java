package d30;

import j$.util.Optional;
import j$.util.function.Function;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class j0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return (JupiterTestDescriptor) ((Optional) obj).get();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
