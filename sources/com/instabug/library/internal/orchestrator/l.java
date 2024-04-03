package com.instabug.library.internal.orchestrator;

import com.instabug.library.internal.storage.cache.user.UserCacheManager;

public class l implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final String f51003a;

    /* renamed from: b  reason: collision with root package name */
    private final long f51004b;

    public l(String str, long j11) {
        this.f51003a = str;
        this.f51004b = j11;
    }

    public void run() throws Exception {
        UserCacheManager.updateLastSeen(this.f51003a, this.f51004b);
    }
}
