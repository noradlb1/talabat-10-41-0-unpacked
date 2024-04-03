package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class e0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTreeWalker f28077b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f28078c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NodeExecutionAdvisor f28079d;

    public /* synthetic */ e0(NodeTreeWalker nodeTreeWalker, TestDescriptor testDescriptor, NodeExecutionAdvisor nodeExecutionAdvisor) {
        this.f28077b = nodeTreeWalker;
        this.f28078c = testDescriptor;
        this.f28079d = nodeExecutionAdvisor;
    }

    public final void accept(Object obj) {
        this.f28077b.lambda$walk$1(this.f28078c, this.f28079d, (TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
