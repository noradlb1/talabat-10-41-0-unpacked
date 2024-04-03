package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

class zzfto<K, V> extends zzfup<K> {
    final Map<K, V> zzd;

    public zzfto(Map<K, V> map) {
        map.getClass();
        this.zzd = map;
    }

    public void clear() {
        this.zzd.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zzd.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.zzd.isEmpty();
    }

    public Iterator<K> iterator() {
        return new zzftl(this.zzd.entrySet().iterator());
    }

    public boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.zzd.remove(obj);
        return true;
    }

    public final int size() {
        return this.zzd.size();
    }
}
