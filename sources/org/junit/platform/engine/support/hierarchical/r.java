package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28099b;

    public /* synthetic */ r(NodeTestTask nodeTestTask) {
        this.f28099b = nodeTestTask;
    }

    public final void accept(Object obj) {
        this.f28099b.lambda$executeRecursively$5((NodeTestTask) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
