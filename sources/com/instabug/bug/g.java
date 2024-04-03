package com.instabug.bug;

import com.instabug.bug.BugReporting;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.invocation.InvocationManager;
import io.reactivex.functions.Consumer;

class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugReporting.r f45644b;

    public g(BugReporting.r rVar) {
        this.f45644b = rVar;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals("sdk_state") && sDKCoreEvent.getValue().equals("built")) {
            InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonOffsetFromTop(this.f45644b.f45616a);
        }
    }
}
