package n30;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.ClassSelector;

public final /* synthetic */ class p implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((ClassSelector) obj).getClassName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
