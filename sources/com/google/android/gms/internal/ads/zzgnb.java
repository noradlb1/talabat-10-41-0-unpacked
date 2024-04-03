package com.google.android.gms.internal.ads;

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

class zzgnb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    /* access modifiers changed from: private */
    public List<zzgmv> zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map<K, V> zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzgmz zze;
    private Map<K, V> zzf = Collections.emptyMap();

    public /* synthetic */ zzgnb(int i11, zzgna zzgna) {
        this.zza = i11;
    }

    private final int zzk(K k11) {
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
    public final V zzl(int i11) {
        zzn();
        V value = this.zzb.remove(i11).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List<zzgmv> list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzgmv(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap<K, V> zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzk(comparable) >= 0 || this.zzc.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzgmz(this, (zzgmy) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgnb)) {
            return super.equals(obj);
        }
        zzgnb zzgnb = (zzgnb) obj;
        int size = size();
        if (size != zzgnb.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzgnb.zzb()) {
            return entrySet().equals(zzgnb.entrySet());
        }
        for (int i11 = 0; i11 < zzb2; i11++) {
            if (!zzg(i11).equals(zzgnb.zzg(i11))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzgnb.zzc);
        }
        return true;
    }

    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return this.zzb.get(zzk).getValue();
        }
        return this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i11 = 0;
        for (int i12 = 0; i12 < zzb2; i12++) {
            i11 += this.zzb.get(i12).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i11 + this.zzc.hashCode();
        }
        return i11;
    }

    public final V remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
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

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        if (this.zzc.isEmpty()) {
            return zzgmu.zza();
        }
        return this.zzc.entrySet();
    }

    /* renamed from: zze */
    public final V put(K k11, V v11) {
        zzn();
        int zzk = zzk(k11);
        if (zzk >= 0) {
            return this.zzb.get(zzk).setValue(v11);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i11 = -(zzk + 1);
        if (i11 >= this.zza) {
            return zzm().put(k11, v11);
        }
        int size = this.zzb.size();
        int i12 = this.zza;
        if (size == i12) {
            zzgmv remove = this.zzb.remove(i12 - 1);
            zzm().put(remove.zza(), remove.getValue());
        }
        this.zzb.add(i11, new zzgmv(this, k11, v11));
        return null;
    }

    public final Map.Entry<K, V> zzg(int i11) {
        return this.zzb.get(i11);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
