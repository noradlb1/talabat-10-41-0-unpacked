package l30;

import j$.util.Collection;
import j$.util.function.Function;
import java.util.List;

public final /* synthetic */ class i2 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(Collection.EL.stream((List) obj).anyMatch(new j2()));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
