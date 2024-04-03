package com.instabug.library.util.filters;

import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.util.filters.actions.a;
import java.util.HashMap;
import java.util.Map;

class f implements a {
    /* renamed from: a */
    public void apply(HashMap hashMap) {
        if (hashMap != null) {
            for (Map.Entry key : hashMap.entrySet()) {
                UserAttributeCacheManager.delete((String) key.getKey());
            }
        }
    }
}
