package m30;

import j$.util.function.Function;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class v implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((UniqueId.Segment) obj).getValue();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
