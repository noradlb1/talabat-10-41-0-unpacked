package com.google.android.gms.internal.places;

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

class zzdb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzfk;
    private final int zzlp;
    /* access modifiers changed from: private */
    public List<zzdk> zzlq;
    /* access modifiers changed from: private */
    public Map<K, V> zzlr;
    private volatile zzdm zzls;
    /* access modifiers changed from: private */
    public Map<K, V> zzlt;
    private volatile zzdg zzlu;

    private zzdb(int i11) {
        this.zzlp = i11;
        this.zzlq = Collections.emptyList();
        this.zzlr = Collections.emptyMap();
        this.zzlt = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzax<FieldDescriptorType>> zzdb<FieldDescriptorType, Object> zzal(int i11) {
        return new zzde(i11);
    }

    /* access modifiers changed from: private */
    public final V zzan(int i11) {
        zzcx();
        V value = this.zzlq.remove(i11).getValue();
        if (!this.zzlr.isEmpty()) {
            Iterator it = zzcy().entrySet().iterator();
            this.zzlq.add(new zzdk(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzcx() {
        if (this.zzfk) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzcy() {
        zzcx();
        if (this.zzlr.isEmpty() && !(this.zzlr instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzlr = treeMap;
            this.zzlt = treeMap.descendingMap();
        }
        return (SortedMap) this.zzlr;
    }

    public void clear() {
        zzcx();
        if (!this.zzlq.isEmpty()) {
            this.zzlq.clear();
        }
        if (!this.zzlr.isEmpty()) {
            this.zzlr.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzb(comparable) >= 0 || this.zzlr.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzls == null) {
            this.zzls = new zzdm(this, (zzde) null);
        }
        return this.zzls;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdb)) {
            return super.equals(obj);
        }
        zzdb zzdb = (zzdb) obj;
        int size = size();
        if (size != zzdb.size()) {
            return false;
        }
        int zzcu = zzcu();
        if (zzcu != zzdb.zzcu()) {
            return entrySet().equals(zzdb.entrySet());
        }
        for (int i11 = 0; i11 < zzcu; i11++) {
            if (!zzam(i11).equals(zzdb.zzam(i11))) {
                return false;
            }
        }
        if (zzcu != size) {
            return this.zzlr.equals(zzdb.zzlr);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzb = zzb(comparable);
        if (zzb >= 0) {
            return this.zzlq.get(zzb).getValue();
        }
        return this.zzlr.get(comparable);
    }

    public int hashCode() {
        int zzcu = zzcu();
        int i11 = 0;
        for (int i12 = 0; i12 < zzcu; i12++) {
            i11 += this.zzlq.get(i12).hashCode();
        }
        if (this.zzlr.size() > 0) {
            return i11 + this.zzlr.hashCode();
        }
        return i11;
    }

    public final boolean isImmutable() {
        return this.zzfk;
    }

    public V remove(Object obj) {
        zzcx();
        Comparable comparable = (Comparable) obj;
        int zzb = zzb(comparable);
        if (zzb >= 0) {
            return zzan(zzb);
        }
        if (this.zzlr.isEmpty()) {
            return null;
        }
        return this.zzlr.remove(comparable);
    }

    public int size() {
        return this.zzlq.size() + this.zzlr.size();
    }

    public void zzab() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzfk) {
            if (this.zzlr.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzlr);
            }
            this.zzlr = map;
            if (this.zzlt.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzlt);
            }
            this.zzlt = map2;
            this.zzfk = true;
        }
    }

    public final Map.Entry<K, V> zzam(int i11) {
        return this.zzlq.get(i11);
    }

    /* renamed from: zzb */
    public final V put(K k11, V v11) {
        zzcx();
        int zzb = zzb(k11);
        if (zzb >= 0) {
            return this.zzlq.get(zzb).setValue(v11);
        }
        zzcx();
        if (this.zzlq.isEmpty() && !(this.zzlq instanceof ArrayList)) {
            this.zzlq = new ArrayList(this.zzlp);
        }
        int i11 = -(zzb + 1);
        if (i11 >= this.zzlp) {
            return zzcy().put(k11, v11);
        }
        int size = this.zzlq.size();
        int i12 = this.zzlp;
        if (size == i12) {
            zzdk remove = this.zzlq.remove(i12 - 1);
            zzcy().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzlq.add(i11, new zzdk(this, k11, v11));
        return null;
    }

    public final int zzcu() {
        return this.zzlq.size();
    }

    public final Iterable<Map.Entry<K, V>> zzcv() {
        if (this.zzlr.isEmpty()) {
            return zzdf.zzdf();
        }
        return this.zzlr.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzcw() {
        if (this.zzlu == null) {
            this.zzlu = new zzdg(this, (zzde) null);
        }
        return this.zzlu;
    }

    public /* synthetic */ zzdb(int i11, zzde zzde) {
        this(i11);
    }

    private final int zzb(K k11) {
        int size = this.zzlq.size() - 1;
        if (size >= 0) {
            int compareTo = k11.compareTo((Comparable) this.zzlq.get(size).getKey());
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
            int compareTo2 = k11.compareTo((Comparable) this.zzlq.get(i12).getKey());
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
