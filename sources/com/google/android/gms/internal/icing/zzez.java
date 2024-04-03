package com.google.android.gms.internal.icing;

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

class zzez<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    /* access modifiers changed from: private */
    public List<zzew> zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map<K, V> zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzey zze;
    private Map<K, V> zzf = Collections.emptyMap();

    public /* synthetic */ zzez(int i11, zzes zzes) {
        this.zza = i11;
    }

    /* access modifiers changed from: private */
    public final V zzk(int i11) {
        zzm();
        V value = this.zzb.remove(i11).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzn().entrySet().iterator();
            List<zzew> list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzew(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final int zzl(K k11) {
        int size = this.zzb.size() - 1;
        int i11 = 0;
        if (size >= 0) {
            int compareTo = k11.compareTo(this.zzb.get(size).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            int compareTo2 = k11.compareTo(this.zzb.get(i12).zza());
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

    /* access modifiers changed from: private */
    public final void zzm() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzn() {
        zzm();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    public final void clear() {
        zzm();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzl(comparable) >= 0 || this.zzc.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzey(this, (zzes) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzez)) {
            return super.equals(obj);
        }
        zzez zzez = (zzez) obj;
        int size = size();
        if (size != zzez.size()) {
            return false;
        }
        int zzc2 = zzc();
        if (zzc2 != zzez.zzc()) {
            return entrySet().equals(zzez.entrySet());
        }
        for (int i11 = 0; i11 < zzc2; i11++) {
            if (!zzd(i11).equals(zzez.zzd(i11))) {
                return false;
            }
        }
        if (zzc2 != size) {
            return this.zzc.equals(zzez.zzc);
        }
        return true;
    }

    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return this.zzb.get(zzl).getValue();
        }
        return this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzc2 = zzc();
        int i11 = 0;
        for (int i12 = 0; i12 < zzc2; i12++) {
            i11 += this.zzb.get(i12).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i11 + this.zzc.hashCode();
        }
        return i11;
    }

    public final V remove(Object obj) {
        zzm();
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return zzk(zzl);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = map;
            if (this.zzf.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = map2;
            this.zzd = true;
        }
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Map.Entry<K, V> zzd(int i11) {
        return this.zzb.get(i11);
    }

    public final Iterable<Map.Entry<K, V>> zze() {
        if (this.zzc.isEmpty()) {
            return zzev.zza();
        }
        return this.zzc.entrySet();
    }

    /* renamed from: zzf */
    public final V put(K k11, V v11) {
        zzm();
        int zzl = zzl(k11);
        if (zzl >= 0) {
            return this.zzb.get(zzl).setValue(v11);
        }
        zzm();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i11 = -(zzl + 1);
        if (i11 >= this.zza) {
            return zzn().put(k11, v11);
        }
        int size = this.zzb.size();
        int i12 = this.zza;
        if (size == i12) {
            zzew remove = this.zzb.remove(i12 - 1);
            zzn().put(remove.zza(), remove.getValue());
        }
        this.zzb.add(i11, new zzew(this, k11, v11));
        return null;
    }
}
