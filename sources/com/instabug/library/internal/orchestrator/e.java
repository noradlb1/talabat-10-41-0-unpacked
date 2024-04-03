package com.instabug.library.internal.orchestrator;

import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.user.UserCacheManager;

public class e implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final String f50997a;

    public e(String str) {
        this.f50997a = str;
    }

    public void run() throws Exception {
        CacheManager.getInstance().invalidateAllCachesForIdentifyingUsers();
        UserCacheManager.updateLastSeen(this.f50997a, 0);
    }
}
