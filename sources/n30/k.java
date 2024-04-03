package n30;

import j$.util.function.Function;
import java.util.Collections;
import java.util.TreeSet;

public final /* synthetic */ class k implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Collections.unmodifiableSortedSet((TreeSet) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
