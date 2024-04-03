package com.instabug.chat.cache;

import com.instabug.chat.model.d;
import com.instabug.library.internal.storage.cache.CacheManager;

class i extends CacheManager.KeyExtractor {
    public i(j jVar) {
    }

    /* renamed from: a */
    public String extractKey(d dVar) {
        return dVar.getId();
    }
}
