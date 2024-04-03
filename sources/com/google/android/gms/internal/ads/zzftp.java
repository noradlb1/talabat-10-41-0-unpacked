package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzftp<K, V> extends AbstractCollection<V> {
    final Map<K, V> zza;

    public zzftp(Map<K, V> map) {
        this.zza = map;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsValue(obj);
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator<V> iterator() {
        return new zzftm(this.zza.entrySet().iterator());
    }

    public final boolean remove(@CheckForNull Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry next : this.zza.entrySet()) {
                if (zzfqc.zza(obj, next.getValue())) {
                    this.zza.remove(next.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean removeAll(Collection<?> collection) {
        collection.getClass();
        try {
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry next : this.zza.entrySet()) {
                if (collection.contains(next.getValue())) {
                    hashSet.add(next.getKey());
                }
            }
            return this.zza.keySet().removeAll(hashSet);
        }
    }

    public final boolean retainAll(Collection<?> collection) {
        collection.getClass();
        try {
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry next : this.zza.entrySet()) {
                if (collection.contains(next.getValue())) {
                    hashSet.add(next.getKey());
                }
            }
            return this.zza.keySet().retainAll(hashSet);
        }
    }

    public final int size() {
        return this.zza.size();
    }
}
