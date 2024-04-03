package q30;

import j$.util.function.Function;
import java.util.Objects;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class f implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Objects.toString((TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
