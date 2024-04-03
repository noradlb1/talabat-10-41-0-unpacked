package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.TestInstanceFactory;

public final /* synthetic */ class w implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestInstanceFactory) obj).getClass().getName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
