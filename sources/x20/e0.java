package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.MethodDescriptor;

public final /* synthetic */ class e0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((MethodDescriptor) obj).getDisplayName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
