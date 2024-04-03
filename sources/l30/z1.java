package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.ExceptionUtils;

public final /* synthetic */ class z1 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ExceptionUtils.throwAsUncheckedException((Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
