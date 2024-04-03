package d30;

import j$.util.function.Function;
import java.util.Collections;
import java.util.LinkedHashSet;

public final /* synthetic */ class c implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Collections.unmodifiableSet((LinkedHashSet) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
