package com.instabug.library.internal.orchestrator;

import com.instabug.library.internal.storage.cache.user.UserCacheManager;

public class a implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final String f50991a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50992b;

    public a(String str, int i11) {
        this.f50991a = str;
        this.f50992b = i11;
    }

    public void run() throws Exception {
        UserCacheManager.updateSessionCount(this.f50991a, this.f50992b);
    }
}
