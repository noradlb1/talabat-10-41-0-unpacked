package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Supplier;

public final /* synthetic */ class u implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28102a;

    public /* synthetic */ u(NodeTestTask nodeTestTask) {
        this.f28102a = nodeTestTask;
    }

    public final Object get() {
        return this.f28102a.lambda$reportCompletion$11();
    }
}
