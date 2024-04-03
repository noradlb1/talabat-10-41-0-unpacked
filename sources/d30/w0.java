package d30;

import j$.util.function.Function;
import org.junit.platform.engine.TestTag;

public final /* synthetic */ class w0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return TestTag.create((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
