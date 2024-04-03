package d30;

import j$.util.DesugarArrays;
import j$.util.function.Function;

public final /* synthetic */ class p0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DesugarArrays.stream((T[]) (Class[]) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
