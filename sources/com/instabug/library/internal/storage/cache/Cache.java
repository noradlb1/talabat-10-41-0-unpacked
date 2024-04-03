package com.instabug.library.internal.storage.cache;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class Cache<K, V> {
    private int appVersion;

    /* renamed from: id  reason: collision with root package name */
    private String f51026id;
    private final List<CacheChangedListener<V>> listeners;

    public Cache(String str) {
        this(str, 1);
    }

    public boolean addOnCacheChangedListener(CacheChangedListener<V> cacheChangedListener) {
        return !this.listeners.contains(cacheChangedListener) && this.listeners.add(cacheChangedListener);
    }

    public abstract V delete(K k11);

    @Nullable
    public abstract V get(K k11);

    public int getAppVersion() {
        return this.appVersion;
    }

    public String getId() {
        return this.f51026id;
    }

    public abstract List<V> getValues();

    public abstract void invalidate();

    public void notifyCacheInvalidated() {
        for (CacheChangedListener<V> onCacheInvalidated : this.listeners) {
            onCacheInvalidated.onCacheInvalidated();
        }
    }

    public void notifyItemAdded(V v11) {
        for (CacheChangedListener<V> onCachedItemAdded : this.listeners) {
            onCachedItemAdded.onCachedItemAdded(v11);
        }
    }

    public void notifyItemRemoved(V v11) {
        for (CacheChangedListener<V> onCachedItemRemoved : this.listeners) {
            onCachedItemRemoved.onCachedItemRemoved(v11);
        }
    }

    public void notifyItemUpdated(V v11, V v12) {
        for (CacheChangedListener<V> onCachedItemUpdated : this.listeners) {
            onCachedItemUpdated.onCachedItemUpdated(v11, v12);
        }
    }

    public abstract V put(K k11, V v11);

    public boolean removeOnCacheChangedListener(CacheChangedListener<V> cacheChangedListener) {
        return this.listeners.remove(cacheChangedListener);
    }

    public abstract long size();

    public Cache(String str, int i11) {
        this.f51026id = str;
        this.appVersion = i11;
        this.listeners = new ArrayList();
    }
}
