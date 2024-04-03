package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;
import java.util.Set;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class g0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTreeWalker f28083b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Set f28084c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NodeExecutionAdvisor f28085d;

    public /* synthetic */ g0(NodeTreeWalker nodeTreeWalker, Set set, NodeExecutionAdvisor nodeExecutionAdvisor) {
        this.f28083b = nodeTreeWalker;
        this.f28084c = set;
        this.f28085d = nodeExecutionAdvisor;
    }

    public final void accept(Object obj) {
        this.f28083b.lambda$walk$3(this.f28084c, this.f28085d, (TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
