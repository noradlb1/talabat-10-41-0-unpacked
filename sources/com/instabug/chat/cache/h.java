package com.instabug.chat.cache;

import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.util.InstabugSDKLogger;

class h implements Runnable {
    public void run() {
        String str;
        Cache cache = CacheManager.getInstance().getCache("chats_memory_cache");
        Cache cache2 = CacheManager.getInstance().getCache("chats_disk_cache");
        if (cache == null || cache2 == null) {
            str = "Chats memory cache was null";
        } else {
            CacheManager.getInstance().migrateCache(cache, cache2, new g(this));
            str = "Chats memory cache had been persisted on-disk";
        }
        InstabugSDKLogger.d("IBG-BR", str);
    }
}
