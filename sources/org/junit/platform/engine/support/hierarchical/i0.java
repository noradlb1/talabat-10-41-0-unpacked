package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class i0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeExecutionAdvisor f28089b;

    public /* synthetic */ i0(NodeExecutionAdvisor nodeExecutionAdvisor) {
        this.f28089b = nodeExecutionAdvisor;
    }

    public final void accept(Object obj) {
        this.f28089b.b((TestDescriptor) obj, Node.ExecutionMode.SAME_THREAD);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
