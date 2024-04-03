package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtendWith;

public final /* synthetic */ class o0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((ExtendWith) obj).value();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
