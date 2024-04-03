package com.instabug.chat.cache;

import com.instabug.chat.model.d;
import com.instabug.library.internal.storage.cache.Cache;
import com.instabug.library.internal.storage.cache.CacheManager;
import java.util.List;

class j implements Runnable {
    public void run() {
        Cache cache = CacheManager.getInstance().getCache("chats_disk_cache");
        if (cache != null) {
            List<d> values = cache.getValues();
            i iVar = new i(this);
            cache.invalidate();
            for (d dVar : values) {
                cache.put(iVar.extractKey(dVar), dVar);
            }
        }
    }
}
