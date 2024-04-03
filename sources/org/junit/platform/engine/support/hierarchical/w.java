package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class w implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28104a;

    public /* synthetic */ w(NodeTestTask nodeTestTask) {
        this.f28104a = nodeTestTask;
    }

    public final void execute() {
        this.f28104a.lambda$executeRecursively$9();
    }
}
