package q30;

import j$.util.function.Function;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class e implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((SelectorResolver.Resolution) obj).getMatches();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
