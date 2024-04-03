package d30;

import j$.util.function.Function;
import java.net.URI;
import org.junit.jupiter.engine.descriptor.TestFactoryTestDescriptor;

public final /* synthetic */ class g1 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return TestFactoryTestDescriptor.N((URI) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
