package com.deliveryhero.persistence.cache;

import androidx.annotation.Nullable;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class MemoryCacheImpl implements MemoryCache {
    private Map<String, CacheData> cache = new ConcurrentHashMap();

    @Nullable
    public <T> T get(String str) {
        boolean z11;
        CacheData cacheData = this.cache.get(str);
        if (cacheData == null || !cacheData.isExpired()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            remove(str);
        }
        if (cacheData == null || cacheData.isExpired()) {
            return null;
        }
        return cacheData.getData();
    }

    public <T> void put(String str, T t11, long j11) {
        this.cache.put(str, new CacheData(t11, j11));
    }

    public void remove(String str) {
        this.cache.remove(str);
    }

    public <T> void put(String str, T t11) {
        put(str, t11, 0);
    }
}
