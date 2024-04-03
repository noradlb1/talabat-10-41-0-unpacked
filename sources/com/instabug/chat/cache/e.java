package com.instabug.chat.cache;

import com.instabug.chat.model.d;
import com.instabug.library.internal.storage.cache.CacheManager;

class e extends CacheManager.KeyExtractor {
    public e(f fVar) {
    }

    /* renamed from: a */
    public String extractKey(d dVar) {
        return dVar.getId();
    }
}
