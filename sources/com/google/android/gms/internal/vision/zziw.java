package com.google.android.gms.internal.vision;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zziw<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private volatile zzix zzaaa;
    private boolean zztc;
    private final int zzzv;
    /* access modifiers changed from: private */
    public List<zzjb> zzzw;
    /* access modifiers changed from: private */
    public Map<K, V> zzzx;
    private volatile zzjd zzzy;
    /* access modifiers changed from: private */
    public Map<K, V> zzzz;

    private zziw(int i11) {
        this.zzzv = i11;
        this.zzzw = Collections.emptyList();
        this.zzzx = Collections.emptyMap();
        this.zzzz = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzgk<FieldDescriptorType>> zziw<FieldDescriptorType, Object> zzbt(int i11) {
        return new zziv(i11);
    }

    /* access modifiers changed from: private */
    public final V zzbv(int i11) {
        zzia();
        V value = this.zzzw.remove(i11).getValue();
        if (!this.zzzx.isEmpty()) {
            Iterator it = zzib().entrySet().iterator();
            this.zzzw.add(new zzjb(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzia() {
        if (this.zztc) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzib() {
        zzia();
        if (this.zzzx.isEmpty() && !(this.zzzx instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzzx = treeMap;
            this.zzzz = treeMap.descendingMap();
        }
        return (SortedMap) this.zzzx;
    }

    public void clear() {
        zzia();
        if (!this.zzzw.isEmpty()) {
            this.zzzw.clear();
        }
        if (!this.zzzx.isEmpty()) {
            this.zzzx.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zza(comparable) >= 0 || this.zzzx.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzzy == null) {
            this.zzzy = new zzjd(this, (zziv) null);
        }
        return this.zzzy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziw)) {
            return super.equals(obj);
        }
        zziw zziw = (zziw) obj;
        int size = size();
        if (size != zziw.size()) {
            return false;
        }
        int zzhx = zzhx();
        if (zzhx != zziw.zzhx()) {
            return entrySet().equals(zziw.entrySet());
        }
        for (int i11 = 0; i11 < zzhx; i11++) {
            if (!zzbu(i11).equals(zziw.zzbu(i11))) {
                return false;
            }
        }
        if (zzhx != size) {
            return this.zzzx.equals(zziw.zzzx);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzzw.get(zza).getValue();
        }
        return this.zzzx.get(comparable);
    }

    public int hashCode() {
        int zzhx = zzhx();
        int i11 = 0;
        for (int i12 = 0; i12 < zzhx; i12++) {
            i11 += this.zzzw.get(i12).hashCode();
        }
        if (this.zzzx.size() > 0) {
            return i11 + this.zzzx.hashCode();
        }
        return i11;
    }

    public final boolean isImmutable() {
        return this.zztc;
    }

    public V remove(Object obj) {
        zzia();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzbv(zza);
        }
        if (this.zzzx.isEmpty()) {
            return null;
        }
        return this.zzzx.remove(comparable);
    }

    public int size() {
        return this.zzzw.size() + this.zzzx.size();
    }

    /* renamed from: zza */
    public final V put(K k11, V v11) {
        zzia();
        int zza = zza(k11);
        if (zza >= 0) {
            return this.zzzw.get(zza).setValue(v11);
        }
        zzia();
        if (this.zzzw.isEmpty() && !(this.zzzw instanceof ArrayList)) {
            this.zzzw = new ArrayList(this.zzzv);
        }
        int i11 = -(zza + 1);
        if (i11 >= this.zzzv) {
            return zzib().put(k11, v11);
        }
        int size = this.zzzw.size();
        int i12 = this.zzzv;
        if (size == i12) {
            zzjb remove = this.zzzw.remove(i12 - 1);
            zzib().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzzw.add(i11, new zzjb(this, k11, v11));
        return null;
    }

    public final Map.Entry<K, V> zzbu(int i11) {
        return this.zzzw.get(i11);
    }

    public void zzdp() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zztc) {
            if (this.zzzx.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzzx);
            }
            this.zzzx = map;
            if (this.zzzz.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzzz);
            }
            this.zzzz = map2;
            this.zztc = true;
        }
    }

    public final int zzhx() {
        return this.zzzw.size();
    }

    public final Iterable<Map.Entry<K, V>> zzhy() {
        if (this.zzzx.isEmpty()) {
            return zzja.zzid();
        }
        return this.zzzx.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzhz() {
        if (this.zzaaa == null) {
            this.zzaaa = new zzix(this, (zziv) null);
        }
        return this.zzaaa;
    }

    public /* synthetic */ zziw(int i11, zziv zziv) {
        this(i11);
    }

    private final int zza(K k11) {
        int size = this.zzzw.size() - 1;
        if (size >= 0) {
            int compareTo = k11.compareTo((Comparable) this.zzzw.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            int compareTo2 = k11.compareTo((Comparable) this.zzzw.get(i12).getKey());
            if (compareTo2 < 0) {
                size = i12 - 1;
            } else if (compareTo2 <= 0) {
                return i12;
            } else {
                i11 = i12 + 1;
            }
        }
        return -(i11 + 1);
    }
}
