package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class b2 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestTemplateTestDescriptor f61833b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Node.DynamicTestExecutor f61834c;

    public /* synthetic */ b2(TestTemplateTestDescriptor testTemplateTestDescriptor, Node.DynamicTestExecutor dynamicTestExecutor) {
        this.f61833b = testTemplateTestDescriptor;
        this.f61834c = dynamicTestExecutor;
    }

    public final void accept(Object obj) {
        this.f61833b.lambda$execute$2(this.f61834c, (TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
