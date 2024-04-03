package com.instabug.library;

import com.instabug.library.Instabug;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Instabug.q f50531b;

    public c(Instabug.q qVar) {
        this.f50531b = qVar;
    }

    public void run() {
        SettingsManager.getInstance().setWelcomeMessageState(this.f50531b.f50518a);
        InstabugSDKLogger.d("IBG-Core", "setWelcomeMessageState: " + this.f50531b.f50518a.name());
    }
}
