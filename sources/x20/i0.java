package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.MethodOrderer;

public final /* synthetic */ class i0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MethodOrderer.Random.lambda$getCustomSeed$3((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
