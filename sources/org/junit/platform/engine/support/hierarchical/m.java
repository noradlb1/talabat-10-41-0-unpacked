package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class m implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28094a;

    public /* synthetic */ m(NodeTestTask nodeTestTask) {
        this.f28094a = nodeTestTask;
    }

    public final void execute() {
        this.f28094a.lambda$executeRecursively$6();
    }
}
