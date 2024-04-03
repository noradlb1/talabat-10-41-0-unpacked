package com.google.android.gms.internal.icing;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzey extends AbstractSet<Map.Entry> {
    final /* synthetic */ zzez zza;

    public /* synthetic */ zzey(zzez zzez, zzes zzes) {
        this.zza = zzez;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(value)) {
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry> iterator() {
        return new zzex(this.zza, (zzes) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
