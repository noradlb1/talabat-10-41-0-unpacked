package f30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.StringUtils;

public final /* synthetic */ class s implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return StringUtils.defaultToString((ParameterResolver) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
