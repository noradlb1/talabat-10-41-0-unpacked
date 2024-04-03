package e30;

import j$.util.Optional;
import j$.util.function.Function;
import org.junit.jupiter.api.MethodOrderer;

public final /* synthetic */ class r implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Optional.of((MethodOrderer) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
