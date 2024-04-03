package com.instabug.library.user;

import com.instabug.library.internal.storage.cache.db.InstabugDBInsertionListener;
import com.instabug.library.internal.storage.cache.user.UserCacheManager;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstabugDBInsertionListener f51996b;

    public e(InstabugDBInsertionListener instabugDBInsertionListener) {
        this.f51996b = instabugDBInsertionListener;
    }

    public void run() {
        if (f.f51997a != null) {
            UserCacheManager.insertIfNotExists(f.f51997a, f.j());
            InstabugDBInsertionListener instabugDBInsertionListener = this.f51996b;
            if (instabugDBInsertionListener != null) {
                instabugDBInsertionListener.onDataInserted(f.f51997a);
            }
        }
    }
}
