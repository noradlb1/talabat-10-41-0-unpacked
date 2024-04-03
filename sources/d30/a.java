package d30;

import j$.util.function.Function;
import org.junit.platform.engine.TestTag;

public final /* synthetic */ class a implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestTag) obj).getName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
