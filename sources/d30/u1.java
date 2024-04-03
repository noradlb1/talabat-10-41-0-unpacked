package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public final /* synthetic */ class u1 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestTemplateInvocationContextProvider) obj).getClass().getSimpleName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
