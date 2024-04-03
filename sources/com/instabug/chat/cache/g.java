package com.instabug.chat.cache;

import com.instabug.chat.model.d;
import com.instabug.library.internal.storage.cache.CacheManager;

class g extends CacheManager.KeyExtractor {
    public g(h hVar) {
    }

    /* renamed from: a */
    public String extractKey(d dVar) {
        return dVar.getId();
    }
}
