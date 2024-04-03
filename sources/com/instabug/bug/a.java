package com.instabug.bug;

import com.instabug.bug.BugReporting;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.invocation.InvocationManager;
import io.reactivex.functions.Consumer;

class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugReporting.k f45620b;

    public a(BugReporting.k kVar) {
        this.f45620b = kVar;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (sDKCoreEvent.getType().equals("sdk_state") && sDKCoreEvent.getValue().equals("built")) {
            InvocationManager.getInstance().setInstabugInvocationEvent(this.f45620b.f45609a);
        }
    }
}
