package l30;

import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class j implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return AnnotationUtils.lambda$isRepeatableAnnotationContainer$3((Method) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
