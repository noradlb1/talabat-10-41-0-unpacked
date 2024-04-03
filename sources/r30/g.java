package r30;

import j$.util.function.Function;
import org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService;

public final /* synthetic */ class g implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ForkJoinPoolHierarchicalTestExecutorService.lambda$createForkJoinPool$3((Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
