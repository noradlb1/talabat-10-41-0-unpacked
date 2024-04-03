package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;
import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class k0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Node.DynamicTestExecutor f61884b;

    public /* synthetic */ k0(Node.DynamicTestExecutor dynamicTestExecutor) {
        this.f61884b = dynamicTestExecutor;
    }

    public final void accept(Object obj) {
        this.f61884b.execute((JupiterTestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
