package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.CheckForNull;

abstract class zzftn<K, V> extends zzfup<Map.Entry<K, V>> {
    public final void clear() {
        zza().clear();
    }

    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzftr.zza(zza(), key);
        if (!zzfqc.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null) {
            return true;
        }
        if (!zza().containsKey(key)) {
            return false;
        }
        return true;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(@CheckForNull Object obj) {
        if (!contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        return zza().keySet().remove(((Map.Entry) obj).getKey());
    }

    public final boolean removeAll(Collection<?> collection) {
        collection.getClass();
        try {
            return zzfuq.zzb(this, collection);
        } catch (UnsupportedOperationException unused) {
            return zzfuq.zzc(this, collection.iterator());
        }
    }

    public final boolean retainAll(Collection<?> collection) {
        int i11;
        collection.getClass();
        try {
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzfrr.zza(size, "expectedSize");
                i11 = size + 1;
            } else if (size < 1073741824) {
                i11 = (int) ((((float) size) / 0.75f) + 1.0f);
            } else {
                i11 = Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i11);
            for (Object next : collection) {
                if (contains(next) && (next instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) next).getKey());
                }
            }
            return zza().keySet().retainAll(hashSet);
        }
    }

    public final int size() {
        return zza().size();
    }

    public abstract Map<K, V> zza();
}
