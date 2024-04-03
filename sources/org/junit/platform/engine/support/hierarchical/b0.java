package org.junit.platform.engine.support.hierarchical;

import java.util.concurrent.Future;
import org.junit.platform.engine.support.hierarchical.NodeTestTask;

public final /* synthetic */ class b0 implements NodeTestTask.DynamicTaskState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Future f28075a;

    public /* synthetic */ b0(Future future) {
        this.f28075a = future;
    }

    public final void awaitFinished() {
        this.f28075a.get();
    }
}
