package e30;

import j$.util.function.Function;
import org.junit.jupiter.api.TestClassOrder;

public final /* synthetic */ class h implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestClassOrder) obj).value();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
