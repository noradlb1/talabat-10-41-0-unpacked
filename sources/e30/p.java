package e30;

import j$.util.function.Function;
import org.junit.jupiter.api.TestMethodOrder;

public final /* synthetic */ class p implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestMethodOrder) obj).value();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
