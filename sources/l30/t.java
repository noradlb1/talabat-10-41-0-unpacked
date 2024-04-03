package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.ClassNamePatternFilterUtils;

public final /* synthetic */ class t implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ClassNamePatternFilterUtils.createPredicateFromPatterns((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
