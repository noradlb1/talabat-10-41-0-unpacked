package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class h0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTreeWalker f28086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NodeExecutionAdvisor f28087c;

    public /* synthetic */ h0(NodeTreeWalker nodeTreeWalker, NodeExecutionAdvisor nodeExecutionAdvisor) {
        this.f28086b = nodeTreeWalker;
        this.f28087c = nodeExecutionAdvisor;
    }

    public final void accept(Object obj) {
        this.f28086b.lambda$walk$0(this.f28087c, (TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
