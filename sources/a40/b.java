package a40;

import j$.util.function.Function;
import org.mockito.internal.verification.argumentmatching.ArgumentMatchingTool;

public final /* synthetic */ class b implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ArgumentMatchingTool.lambda$getNotMatchingArgsWithSameName$1((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
