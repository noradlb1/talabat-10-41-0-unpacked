package y20;

import j$.util.function.Function;
import org.junit.jupiter.api.condition.DisabledIf;

public final /* synthetic */ class d implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((DisabledIf) obj).disabledReason();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
