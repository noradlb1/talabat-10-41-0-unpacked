package g30;

import j$.util.function.Function;
import org.junit.jupiter.api.Timeout;

public final /* synthetic */ class o implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((Timeout) obj).threadMode();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
