package com.instabug.library.internal.storage.cache;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCache<K, V> extends Cache<K, V> {
    private final Map<K, V> map;

    public InMemoryCache(String str) {
        this(str, 1);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public V delete(K k11) {
        V remove;
        synchronized (this.map) {
            remove = this.map.remove(k11);
        }
        if (remove != null) {
            notifyItemRemoved(remove);
        }
        return remove;
    }

    @Nullable
    public V get(K k11) {
        V v11;
        synchronized (this.map) {
            v11 = this.map.get(k11);
        }
        return v11;
    }

    public List<V> getValues() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.map) {
            for (K k11 : this.map.keySet()) {
                Object obj = get(k11);
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    public void invalidate() {
        synchronized (this.map) {
            this.map.clear();
        }
        notifyCacheInvalidated();
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @Nullable
    public V put(K k11, V v11) {
        V put;
        if (v11 == null || k11 == null) {
            return null;
        }
        synchronized (this.map) {
            put = this.map.put(k11, v11);
        }
        if (put == null) {
            notifyItemAdded(v11);
            return v11;
        }
        notifyItemUpdated(put, v11);
        return put;
    }

    public long size() {
        long size;
        synchronized (this.map) {
            size = (long) this.map.size();
        }
        return size;
    }

    public InMemoryCache(String str, int i11) {
        super(str, i11);
        this.map = DesugarCollections.synchronizedMap(new LinkedHashMap());
    }
}
