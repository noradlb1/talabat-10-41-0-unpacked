package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class e1 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((ExtensionContext) obj).getTestInstanceLifecycle();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
