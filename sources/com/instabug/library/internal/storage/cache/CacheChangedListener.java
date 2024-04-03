package com.instabug.library.internal.storage.cache;

public interface CacheChangedListener<V> {
    void onCacheInvalidated();

    void onCachedItemAdded(V v11);

    void onCachedItemRemoved(V v11);

    void onCachedItemUpdated(V v11, V v12);
}
