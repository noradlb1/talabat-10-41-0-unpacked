package com.instabug.library.internal.orchestrator;

import androidx.annotation.Nullable;
import com.instabug.library.settings.SettingsManager;

public class f implements Action {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f50998a;

    public f(@Nullable String str) {
        this.f50998a = str;
    }

    public void run() throws Exception {
        SettingsManager.getInstance().setUserLoggedOut(false);
        SettingsManager.getInstance().setMD5Uuid(this.f50998a);
    }
}
