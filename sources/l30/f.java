package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class f implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return AnnotationUtils.lambda$isRepeatableAnnotationContainer$4((Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
