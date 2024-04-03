package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.ClassOrderer;

public final /* synthetic */ class j implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ClassOrderer.Random.lambda$getCustomSeed$3((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
