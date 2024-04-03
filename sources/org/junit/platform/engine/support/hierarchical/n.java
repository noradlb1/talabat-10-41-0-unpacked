package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class n implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28095a;

    public /* synthetic */ n(NodeTestTask nodeTestTask) {
        this.f28095a = nodeTestTask;
    }

    public final void execute() {
        this.f28095a.lambda$executeRecursively$7();
    }
}
