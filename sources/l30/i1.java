package l30;

import j$.util.function.Function;
import java.nio.file.Paths;

public final /* synthetic */ class i1 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Paths.get((String) obj, new String[0]);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
