package e30;

import j$.util.function.Consumer;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61973b;

    public /* synthetic */ q(ClassBasedTestDescriptor classBasedTestDescriptor) {
        this.f61973b = classBasedTestDescriptor;
    }

    public final void accept(Object obj) {
        this.f61973b.setDefaultChildExecutionMode((Node.ExecutionMode) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
