package com.instabug.library;

import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.ui.onboarding.WelcomeMessage;

class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50530b;

    public b0(c0 c0Var) {
        this.f50530b = c0Var;
    }

    public void run() {
        if (SettingsManager.getInstance().getWelcomeMessageState() != WelcomeMessage.State.DISABLED && InvocationManager.getInstance().getCurrentInstabugInvocationEvents() != null && InvocationManager.getInstance().getCurrentInstabugInvocationEvents().length > 0 && this.f50530b.q()) {
            this.f50530b.c(SettingsManager.getInstance().getWelcomeMessageState());
        }
    }
}
