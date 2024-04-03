package com.instabug.library.internal.orchestrator;

import com.instabug.library.internal.storage.cache.user.UserCacheManager;

public class d implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final String f50995a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50996b;

    public d(String str, int i11) {
        this.f50995a = str;
        this.f50996b = i11;
    }

    public void run() {
        UserCacheManager.insertIfNotExists(this.f50995a, this.f50996b);
    }
}
