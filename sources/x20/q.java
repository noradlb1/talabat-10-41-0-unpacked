package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final /* synthetic */ class q implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((IndicativeSentencesGeneration) obj).generator();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
