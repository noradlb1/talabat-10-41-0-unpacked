package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class s implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28100a;

    public /* synthetic */ s(NodeTestTask nodeTestTask) {
        this.f28100a = nodeTestTask;
    }

    public final void execute() {
        this.f28100a.lambda$cleanUp$10();
    }
}
