package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class t implements Node.Invocation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask f28101a;

    public /* synthetic */ t(NodeTestTask nodeTestTask) {
        this.f28101a = nodeTestTask;
    }

    public final void invoke(EngineExecutionContext engineExecutionContext) {
        this.f28101a.lambda$executeRecursively$8(engineExecutionContext);
    }
}
