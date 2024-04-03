package com.google.android.gms.internal.gtm;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zztl extends AbstractSet {
    private final /* synthetic */ zztc zzbef;

    private zztl(zztc zztc) {
        this.zzbef = zztc;
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzbef.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzbef.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzbef.get(entry.getKey());
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
        return new zztk(this.zzbef, (zztd) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzbef.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzbef.size();
    }

    public /* synthetic */ zztl(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
