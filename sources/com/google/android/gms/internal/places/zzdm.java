package com.google.android.gms.internal.places;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzdm extends AbstractSet {
    private final /* synthetic */ zzdb zzma;

    private zzdm(zzdb zzdb) {
        this.zzma = zzdb;
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzma.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzma.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzma.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value) {
            return true;
        }
        if (obj2 == null || !obj2.equals(value)) {
            return false;
        }
        return true;
    }

    public Iterator iterator() {
        return new zzdj(this.zzma, (zzde) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzma.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzma.size();
    }

    public /* synthetic */ zzdm(zzdb zzdb, zzde zzde) {
        this(zzdb);
    }
}
