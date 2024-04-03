package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class o implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28096a;

    public /* synthetic */ o(NodeTestTask nodeTestTask) {
        this.f28096a = nodeTestTask;
    }

    public final void execute() {
        this.f28096a.lambda$checkWhetherSkipped$3();
    }
}
