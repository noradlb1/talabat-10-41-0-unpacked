package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzjd extends AbstractSet {
    private final /* synthetic */ zziw zzaab;

    private zzjd(zziw zziw) {
        this.zzaab = zziw;
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzaab.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzaab.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzaab.get(entry.getKey());
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
        return new zzje(this.zzaab, (zziv) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzaab.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzaab.size();
    }

    public /* synthetic */ zzjd(zziw zziw, zziv zziv) {
        this(zziw);
    }
}
