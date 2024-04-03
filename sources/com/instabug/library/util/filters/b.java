package com.instabug.library.util.filters;

import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import java.util.HashMap;
import java.util.Map;

class b implements Filter {
    /* renamed from: a */
    public HashMap apply(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (UserAttributeCacheManager.getType((String) entry.getKey()) != 1) {
                    hashMap2.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return hashMap2;
    }
}
