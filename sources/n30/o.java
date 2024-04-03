package n30;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.ClassSelector;

public final /* synthetic */ class o implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return new ClassSelector((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
