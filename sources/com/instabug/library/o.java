package com.instabug.library;

import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.filters.h;

class o implements Runnable {
    public o(c0 c0Var) {
    }

    public void run() {
        Filters.applyOn(UserAttributeCacheManager.retrieveAll()).apply(h.g()).thenDo(h.c());
    }
}
