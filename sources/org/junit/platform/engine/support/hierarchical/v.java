package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Supplier;

public final /* synthetic */ class v implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28103a;

    public /* synthetic */ v(NodeTestTask nodeTestTask) {
        this.f28103a = nodeTestTask;
    }

    public final Object get() {
        return this.f28103a.lambda$reportCompletion$12();
    }
}
