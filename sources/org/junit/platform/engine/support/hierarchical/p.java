package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Supplier;

public final /* synthetic */ class p implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28097a;

    public /* synthetic */ p(NodeTestTask nodeTestTask) {
        this.f28097a = nodeTestTask;
    }

    public final Object get() {
        return this.f28097a.lambda$execute$1();
    }
}
