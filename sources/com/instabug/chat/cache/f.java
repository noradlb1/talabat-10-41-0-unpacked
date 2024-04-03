package com.instabug.chat.cache;

import androidx.annotation.Nullable;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.InMemoryCache;

class f implements ReturnableRunnable {
    @Nullable
    /* renamed from: a */
    public InMemoryCache run() {
        if (!CacheManager.getInstance().cacheExists("chats_memory_cache")) {
            CacheManager.getInstance().migrateCache("chats_disk_cache", "chats_memory_cache", new e(this));
        }
        return (InMemoryCache) CacheManager.getInstance().getCache("chats_memory_cache");
    }
}
