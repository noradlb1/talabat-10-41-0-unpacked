package com.google.android.gms.internal.gtm;

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

class zztc<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzaut;
    private final int zzbdy;
    /* access modifiers changed from: private */
    public List<zztj> zzbdz;
    /* access modifiers changed from: private */
    public Map<K, V> zzbea;
    private volatile zztl zzbeb;
    /* access modifiers changed from: private */
    public Map<K, V> zzbec;
    private volatile zztf zzbed;

    private zztc(int i11) {
        this.zzbdy = i11;
        this.zzbdz = Collections.emptyList();
        this.zzbea = Collections.emptyMap();
        this.zzbec = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzqv<FieldDescriptorType>> zztc<FieldDescriptorType, Object> zzbu(int i11) {
        return new zztd(i11);
    }

    /* access modifiers changed from: private */
    public final V zzbw(int i11) {
        zzrd();
        V value = this.zzbdz.remove(i11).getValue();
        if (!this.zzbea.isEmpty()) {
            Iterator it = zzre().entrySet().iterator();
            this.zzbdz.add(new zztj(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzrd() {
        if (this.zzaut) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzre() {
        zzrd();
        if (this.zzbea.isEmpty() && !(this.zzbea instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzbea = treeMap;
            this.zzbec = treeMap.descendingMap();
        }
        return (SortedMap) this.zzbea;
    }

    public void clear() {
        zzrd();
        if (!this.zzbdz.isEmpty()) {
            this.zzbdz.clear();
        }
        if (!this.zzbea.isEmpty()) {
            this.zzbea.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zza(comparable) >= 0 || this.zzbea.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzbeb == null) {
            this.zzbeb = new zztl(this, (zztd) null);
        }
        return this.zzbeb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zztc)) {
            return super.equals(obj);
        }
        zztc zztc = (zztc) obj;
        int size = size();
        if (size != zztc.size()) {
            return false;
        }
        int zzra = zzra();
        if (zzra != zztc.zzra()) {
            return entrySet().equals(zztc.entrySet());
        }
        for (int i11 = 0; i11 < zzra; i11++) {
            if (!zzbv(i11).equals(zztc.zzbv(i11))) {
                return false;
            }
        }
        if (zzra != size) {
            return this.zzbea.equals(zztc.zzbea);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzbdz.get(zza).getValue();
        }
        return this.zzbea.get(comparable);
    }

    public int hashCode() {
        int zzra = zzra();
        int i11 = 0;
        for (int i12 = 0; i12 < zzra; i12++) {
            i11 += this.zzbdz.get(i12).hashCode();
        }
        if (this.zzbea.size() > 0) {
            return i11 + this.zzbea.hashCode();
        }
        return i11;
    }

    public final boolean isImmutable() {
        return this.zzaut;
    }

    public V remove(Object obj) {
        zzrd();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzbw(zza);
        }
        if (this.zzbea.isEmpty()) {
            return null;
        }
        return this.zzbea.remove(comparable);
    }

    public int size() {
        return this.zzbdz.size() + this.zzbea.size();
    }

    /* renamed from: zza */
    public final V put(K k11, V v11) {
        zzrd();
        int zza = zza(k11);
        if (zza >= 0) {
            return this.zzbdz.get(zza).setValue(v11);
        }
        zzrd();
        if (this.zzbdz.isEmpty() && !(this.zzbdz instanceof ArrayList)) {
            this.zzbdz = new ArrayList(this.zzbdy);
        }
        int i11 = -(zza + 1);
        if (i11 >= this.zzbdy) {
            return zzre().put(k11, v11);
        }
        int size = this.zzbdz.size();
        int i12 = this.zzbdy;
        if (size == i12) {
            zztj remove = this.zzbdz.remove(i12 - 1);
            zzre().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzbdz.add(i11, new zztj(this, k11, v11));
        return null;
    }

    public final Map.Entry<K, V> zzbv(int i11) {
        return this.zzbdz.get(i11);
    }

    public void zzmi() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzaut) {
            if (this.zzbea.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzbea);
            }
            this.zzbea = map;
            if (this.zzbec.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzbec);
            }
            this.zzbec = map2;
            this.zzaut = true;
        }
    }

    public final int zzra() {
        return this.zzbdz.size();
    }

    public final Iterable<Map.Entry<K, V>> zzrb() {
        if (this.zzbea.isEmpty()) {
            return zztg.zzrg();
        }
        return this.zzbea.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzrc() {
        if (this.zzbed == null) {
            this.zzbed = new zztf(this, (zztd) null);
        }
        return this.zzbed;
    }

    public /* synthetic */ zztc(int i11, zztd zztd) {
        this(i11);
    }

    private final int zza(K k11) {
        int size = this.zzbdz.size() - 1;
        if (size >= 0) {
            int compareTo = k11.compareTo((Comparable) this.zzbdz.get(size).getKey());
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
            int compareTo2 = k11.compareTo((Comparable) this.zzbdz.get(i12).getKey());
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
