package com.google.android.recaptcha.internal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzjp extends AbstractMap {
    private final int zza;
    /* access modifiers changed from: private */
    public List zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzjn zze;
    private Map zzf = Collections.emptyMap();

    public /* synthetic */ zzjp(int i11, zzjo zzjo) {
        this.zza = i11;
    }

    private final int zzk(Comparable comparable) {
        int size = this.zzb.size() - 1;
        int i11 = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((zzjj) this.zzb.get(size)).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            int compareTo2 = comparable.compareTo(((zzjj) this.zzb.get(i12)).zza());
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
    public final Object zzl(int i11) {
        zzn();
        Object value = ((zzjj) this.zzb.remove(i11)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzjj(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
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

    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzjn(this, (zzjm) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjp)) {
            return super.equals(obj);
        }
        zzjp zzjp = (zzjp) obj;
        int size = size();
        if (size != zzjp.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzjp.zzb()) {
            return entrySet().equals(zzjp.entrySet());
        }
        for (int i11 = 0; i11 < zzb2; i11++) {
            if (!zzg(i11).equals(zzjp.zzg(i11))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzjp.zzc);
        }
        return true;
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzjj) this.zzb.get(zzk)).getValue();
        }
        return this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i11 = 0;
        for (int i12 = 0; i12 < zzb2; i12++) {
            i11 += ((zzjj) this.zzb.get(i12)).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i11 + this.zzc.hashCode();
        }
        return i11;
    }

    public final Object remove(Object obj) {
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
        Map map;
        Map map2;
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

    public final Iterable zzc() {
        if (this.zzc.isEmpty()) {
            return zzji.zza();
        }
        return this.zzc.entrySet();
    }

    /* renamed from: zze */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzjj) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i11 = -(zzk + 1);
        if (i11 >= this.zza) {
            return zzm().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i12 = this.zza;
        if (size == i12) {
            zzjj zzjj = (zzjj) this.zzb.remove(i12 - 1);
            zzm().put(zzjj.zza(), zzjj.getValue());
        }
        this.zzb.add(i11, new zzjj(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i11) {
        return (Map.Entry) this.zzb.get(i11);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
