package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;

public final /* synthetic */ class g0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MethodOrderer.MethodName.parameterList(((MethodDescriptor) obj).getMethod());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
