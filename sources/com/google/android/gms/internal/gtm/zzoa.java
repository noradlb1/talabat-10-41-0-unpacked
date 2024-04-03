package com.google.android.gms.internal.gtm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class zzoa<T> {
    protected Map<String, zzoa<?>> zzaud;

    public abstract String toString();

    public abstract T value();

    public final void zzc(String str, zzoa<?> zzoa) {
        if (this.zzaud == null) {
            this.zzaud = new HashMap();
        }
        this.zzaud.put(str, zzoa);
    }

    public final boolean zzcn(String str) {
        Map<String, zzoa<?>> map = this.zzaud;
        return map != null && map.containsKey(str);
    }

    public zzoa<?> zzco(String str) {
        Map<String, zzoa<?>> map = this.zzaud;
        return map != null ? map.get(str) : zzog.zzaum;
    }

    public boolean zzcp(String str) {
        return false;
    }

    public zzgz zzcq(String str) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 56);
        sb2.append("Attempting to access Native Method ");
        sb2.append(str);
        sb2.append(" on unsupported type.");
        throw new IllegalStateException(sb2.toString());
    }

    public Iterator<zzoa<?>> zzmf() {
        return new zzoc((zzob) null);
    }

    public final Iterator<zzoa<?>> zzmg() {
        Map<String, zzoa<?>> map = this.zzaud;
        if (map == null) {
            return new zzoc((zzob) null);
        }
        return new zzob(this, map.keySet().iterator());
    }
}
