package com.instabug.library.internal.orchestrator;

import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.f;

public class g implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final String f50999a;

    public g(String str) {
        this.f50999a = str;
    }

    public void run() throws Exception {
        SettingsManager.getInstance().resetSessionCount();
        SettingsManager.getInstance().setUserLoggedOut(true);
        SettingsManager.getInstance().setUuid(this.f50999a);
        SettingsManager.getInstance().setMD5Uuid((String) null);
        f.f("");
        f.g("");
        SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(false);
        f.c();
    }
}
