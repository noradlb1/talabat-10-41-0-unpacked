package com.instabug.library.internal.orchestrator;

import com.instabug.library.internal.storage.cache.user.UserCacheManager;
import com.instabug.library.settings.SettingsManager;

public class j implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final String f51002a;

    public j(String str) {
        this.f51002a = str;
    }

    public void run() throws Exception {
        int sessionsCount = SettingsManager.getInstance().getSessionsCount() + UserCacheManager.getUserSessionCount(this.f51002a);
        UserCacheManager.insertUser(this.f51002a, sessionsCount);
        SettingsManager.getInstance().updateUserSessionCount(sessionsCount);
    }
}
