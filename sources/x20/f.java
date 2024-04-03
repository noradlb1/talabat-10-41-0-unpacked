package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.ClassDescriptor;

public final /* synthetic */ class f implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((ClassDescriptor) obj).getTestClass().getName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
