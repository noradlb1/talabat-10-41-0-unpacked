package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class zzdk<K, V> extends zzdj<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzdg<K, V> zzlw;
    /* access modifiers changed from: private */
    public final transient Object[] zzlx;
    private final transient int zzly = 0;

    public zzdk(zzdg<K, V> zzdg, Object[] objArr, int i11, int i12) {
        this.zzlw = zzdg;
        this.zzlx = objArr;
        this.size = i12;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzlw.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.size;
    }

    public final int zza(Object[] objArr, int i11) {
        return zzcc().zza(objArr, i11);
    }

    public final zzdr<Map.Entry<K, V>> zzby() {
        return (zzdr) zzcc().iterator();
    }

    public final zzdf<Map.Entry<K, V>> zzch() {
        return new zzdn(this);
    }
}
