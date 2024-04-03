package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.DisplayNameGeneration;

public final /* synthetic */ class w implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((DisplayNameGeneration) obj).value();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
