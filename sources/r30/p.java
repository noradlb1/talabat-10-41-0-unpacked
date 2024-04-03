package r30;

import j$.util.function.Consumer;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutorService;

public final /* synthetic */ class p implements Consumer {
    public final void accept(Object obj) {
        ((HierarchicalTestExecutorService.TestTask) obj).execute();
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
