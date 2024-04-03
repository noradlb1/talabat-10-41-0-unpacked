package com.instabug.bug;

import com.instabug.bug.BugReporting;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.invocation.InvocationManager;
import io.reactivex.functions.Consumer;

class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugReporting.q f45643b;

    public f(BugReporting.q qVar) {
        this.f45643b = qVar;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals("sdk_state") && sDKCoreEvent.getValue().equals("built")) {
            InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonEdge(this.f45643b.f45615a);
        }
    }
}
