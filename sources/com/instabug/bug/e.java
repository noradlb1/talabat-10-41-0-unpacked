package com.instabug.bug;

import com.instabug.bug.BugReporting;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.invocation.InvocationManager;
import io.reactivex.functions.Consumer;

class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugReporting.p f45638b;

    public e(BugReporting.p pVar) {
        this.f45638b = pVar;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals("sdk_state") && sDKCoreEvent.getValue().equals("built")) {
            InvocationManager.getInstance().getCurrentInvocationSettings().setShakingThreshold(this.f45638b.f45614a);
        }
    }
}
