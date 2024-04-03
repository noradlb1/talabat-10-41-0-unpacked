package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

abstract class zzfrm<K, V> extends zzfrp<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public transient Map<K, Collection<V>> zza;
    /* access modifiers changed from: private */
    public transient int zzb;

    public zzfrm(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static /* bridge */ /* synthetic */ void zzo(zzfrm zzfrm, Object obj) {
        Collection<V> collection;
        Map<K, Collection<V>> map = zzfrm.zza;
        map.getClass();
        try {
            collection = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            collection = null;
        }
        Collection collection2 = collection;
        if (collection2 != null) {
            int size = collection2.size();
            collection2.clear();
            zzfrm.zzb -= size;
        }
    }

    public abstract Collection<V> zza();

    public <E> Collection<E> zzb(Collection<E> collection) {
        throw null;
    }

    public Collection<V> zzc(K k11, Collection<V> collection) {
        throw null;
    }

    public final int zze() {
        return this.zzb;
    }

    public final Collection<V> zzf() {
        return new zzfro(this);
    }

    public final Iterator<V> zzg() {
        return new zzfqw(this);
    }

    public final List<V> zzh(K k11, List<V> list, @CheckForNull zzfrj zzfrj) {
        if (list instanceof RandomAccess) {
            return new zzfrf(this, k11, list, zzfrj);
        }
        return new zzfrl(this, k11, list, zzfrj);
    }

    public Map<K, Collection<V>> zzj() {
        throw null;
    }

    public final Map<K, Collection<V>> zzk() {
        Map<K, Collection<V>> map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfrd(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfrg(this, (SortedMap) map);
        }
        return new zzfqz(this, map);
    }

    public Set<K> zzl() {
        throw null;
    }

    public final Set<K> zzm() {
        Map<K, Collection<V>> map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfre(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfrh(this, (SortedMap) map);
        }
        return new zzfrc(this, map);
    }

    public final void zzp() {
        for (Collection<V> clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final boolean zzq(K k11, V v11) {
        Collection collection = this.zza.get(k11);
        if (collection == null) {
            Collection zza2 = zza();
            if (zza2.add(v11)) {
                this.zzb++;
                this.zza.put(k11, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v11)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }
}
