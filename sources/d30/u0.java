package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.Tag;

public final /* synthetic */ class u0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((Tag) obj).value();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
