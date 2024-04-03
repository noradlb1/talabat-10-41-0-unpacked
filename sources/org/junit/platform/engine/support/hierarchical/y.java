package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.NodeTestTask;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTestTask.DefaultDynamicTestExecutor f28105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UniqueId f28106c;

    public /* synthetic */ y(NodeTestTask.DefaultDynamicTestExecutor defaultDynamicTestExecutor, UniqueId uniqueId) {
        this.f28105b = defaultDynamicTestExecutor;
        this.f28106c = uniqueId;
    }

    public final void run() {
        this.f28105b.lambda$execute$0(this.f28106c);
    }
}
