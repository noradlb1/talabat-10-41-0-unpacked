package com.instabug.library.util.filters;

import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.util.filters.actions.a;

class d implements a {
    /* renamed from: a */
    public void apply(String str) {
        if (str != null) {
            UserAttributeCacheManager.delete(str);
        }
    }
}
