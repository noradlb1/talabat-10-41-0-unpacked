package s30;

import j$.util.function.Function;
import org.mockito.Mockito;

public final /* synthetic */ class b implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Mockito.withSettings();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
