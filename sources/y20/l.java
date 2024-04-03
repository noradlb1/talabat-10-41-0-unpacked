package y20;

import j$.util.function.Function;
import org.junit.jupiter.api.condition.EnabledOnJre;

public final /* synthetic */ class l implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((EnabledOnJre) obj).disabledReason();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
