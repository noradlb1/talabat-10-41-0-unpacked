package com.instabug.library;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import io.reactivex.functions.Consumer;

class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WelcomeMessage.State f50553b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f50554c;

    public e(c0 c0Var, WelcomeMessage.State state) {
        this.f50554c = c0Var;
        this.f50553b = state;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        if (SDKCoreEvent.Session.TYPE_SESSION.equals(sDKCoreEvent.getType()) && sDKCoreEvent.getValue().equalsIgnoreCase("started") && !InstabugCore.isForegroundBusy()) {
            this.f50554c.b(this.f50553b);
            this.f50554c.U();
        }
    }
}
