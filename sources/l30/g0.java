package l30;

import j$.util.function.Function;
import java.util.Collections;
import java.util.List;

public final /* synthetic */ class g0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Collections.unmodifiableList((List) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
