package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.TestInstances;

public final /* synthetic */ class z implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestInstances) obj).getInnermostInstance();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
