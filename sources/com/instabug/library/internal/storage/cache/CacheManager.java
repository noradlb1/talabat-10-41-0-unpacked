package com.instabug.library.internal.storage.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    public static final String DEFAULT_IN_MEMORY_CACHE_KEY = "DEFAULT_IN_MEMORY_CACHE_KEY";
    private static CacheManager INSTANCE;
    private final List<Cache> caches;

    public static abstract class KeyExtractor<K, V> {
        public abstract K extractKey(V v11);
    }

    public CacheManager() {
        ArrayList arrayList = new ArrayList();
        this.caches = arrayList;
        arrayList.add(new InMemoryCache(DEFAULT_IN_MEMORY_CACHE_KEY));
    }

    public static synchronized CacheManager getInstance() {
        CacheManager cacheManager;
        synchronized (CacheManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new CacheManager();
            }
            cacheManager = INSTANCE;
        }
        return cacheManager;
    }

    public Cache addCache(Cache cache) {
        Cache cache2 = getCache(cache.getId());
        if (cache2 != null) {
            return cache2;
        }
        synchronized (this.caches) {
            this.caches.add(cache);
        }
        return cache;
    }

    public boolean cacheExists(String str) {
        return getCache(str) != null;
    }

    public boolean deleteCache(String str) {
        boolean remove;
        Cache cache = getCache(str);
        if (cache != null) {
            synchronized (this.caches) {
                remove = this.caches.remove(cache);
            }
            return remove;
        }
        InstabugSDKLogger.v("IBG-Core", "No cache was this ID was found " + str + " to be deleted");
        return false;
    }

    @Nullable
    public Cache getCache(String str) {
        synchronized (this.caches) {
            for (Cache next : this.caches) {
                if (next.getId().equals(str)) {
                    return next;
                }
            }
            InstabugSDKLogger.v("IBG-Core", "No cache with this ID was found " + str + " returning null");
            return null;
        }
    }

    public void invalidateAllCaches() {
        synchronized (this.caches) {
            for (Cache invalidateCache : this.caches) {
                invalidateCache(invalidateCache);
            }
        }
        InstabugSDKLogger.v("IBG-Core", "All caches have been invalidated");
    }

    public void invalidateAllCachesButUserAttributes() {
        synchronized (this.caches) {
            for (Cache next : this.caches) {
                if (!next.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY) && !next.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_FILE_NAME) && !next.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_KEY) && !next.getId().equalsIgnoreCase(UserAttributesCacheManager.USER_ATTRIBUTES_MEMORY_CACHE_KEY)) {
                    invalidateCache(next);
                }
            }
        }
        InstabugSDKLogger.v("IBG-Core", "All caches have been invalidated");
    }

    public void invalidateAllCachesForIdentifyingUsers() {
        synchronized (this.caches) {
            for (Cache next : this.caches) {
                if (!next.getId().equals(UserAttributesCacheManager.USER_ATTRIBUTES_MEMORY_CACHE_KEY)) {
                    if (!next.getId().equals(UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_KEY)) {
                        invalidateCache(next);
                    }
                }
            }
        }
        InstabugSDKLogger.v("IBG-Core", "All caches have been invalidated except user attributes cache");
    }

    public void invalidateCache(Cache cache) {
        if (cache != null) {
            cache.invalidate();
            InstabugSDKLogger.v("IBG-Core", "Cache with the ID " + cache.getId() + " have been invalidated");
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public <K, V> void migrateCache(@NonNull String str, @NonNull String str2, KeyExtractor<K, V> keyExtractor) throws IllegalArgumentException {
        Cache cache = getCache(str);
        Cache cache2 = getCache(str2);
        InstabugSDKLogger.v("IBG-Core", "Caches to be migrated " + cache + " - " + cache2);
        if (cache == null) {
            InstabugSDKLogger.v("IBG-Core", "No cache with these key(" + str + ") was found to migrate from");
            return;
        }
        if (cache2 == null) {
            cache2 = new InMemoryCache(str2);
            addCache(cache2);
        }
        migrateCache(cache, cache2, keyExtractor);
    }

    public boolean subscribe(String str, CacheChangedListener cacheChangedListener) {
        Cache cache;
        if (cacheExists(str) && (cache = getCache(str)) != null) {
            return cache.addOnCacheChangedListener(cacheChangedListener);
        }
        throw new IllegalArgumentException("No cache exists with this ID to subscribe to");
    }

    public boolean unSubscribe(String str, CacheChangedListener cacheChangedListener) {
        Cache cache;
        if (!cacheExists(str) || (cache = getCache(str)) == null) {
            return false;
        }
        return cache.removeOnCacheChangedListener(cacheChangedListener);
    }

    public <K, V> void migrateCache(@NonNull Cache<K, V> cache, @NonNull Cache<K, V> cache2, KeyExtractor<K, V> keyExtractor) {
        InstabugSDKLogger.v("IBG-Core", "Invalidated migratingTo cache");
        if (cache2 == null || cache == null) {
            InstabugSDKLogger.e("IBG-Core", "cache migration process got failure, migratingToCache: " + cache2 + ", migratingFromCache: " + cache);
            return;
        }
        cache2.invalidate();
        List<V> values = cache.getValues();
        if (values == null || values.isEmpty()) {
            InstabugSDKLogger.v("IBG-Core", "Cache to migrate from doesn't contain any elements, not going further with the migration");
            return;
        }
        for (V next : values) {
            if (next != null) {
                InstabugSDKLogger.v("IBG-Core", "Adding value " + next + " with key " + keyExtractor.extractKey(next));
                cache2.put(keyExtractor.extractKey(next), next);
            }
        }
    }
}
