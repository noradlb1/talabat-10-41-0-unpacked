package y20;

import j$.util.function.Function;
import org.junit.jupiter.api.condition.DisabledOnJre;

public final /* synthetic */ class e implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((DisabledOnJre) obj).disabledReason();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
