package com.instabug.chat.cache;

import com.instabug.chat.model.o;
import com.instabug.library.internal.storage.cache.CacheManager;

class l extends CacheManager.KeyExtractor {
    /* renamed from: a */
    public String extractKey(o oVar) {
        return String.valueOf(oVar.a());
    }
}
