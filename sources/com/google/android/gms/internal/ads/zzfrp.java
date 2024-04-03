package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

abstract class zzfrp<K, V> implements zzfts<K, V> {
    @CheckForNull
    private transient Set<K> zza;
    @CheckForNull
    private transient Collection<V> zzb;
    @CheckForNull
    private transient Map<K, Collection<V>> zzc;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfts)) {
            return false;
        }
        return zzs().equals(((zzfts) obj).zzs());
    }

    public final int hashCode() {
        return zzs().hashCode();
    }

    public final String toString() {
        return zzs().toString();
    }

    public abstract Collection<V> zzf();

    public Iterator<V> zzg() {
        throw null;
    }

    public abstract Map<K, Collection<V>> zzj();

    public abstract Set<K> zzl();

    public boolean zzq(K k11, V v11) {
        throw null;
    }

    public Collection<V> zzr() {
        Collection<V> collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection<V> zzf = zzf();
        this.zzb = zzf;
        return zzf;
    }

    public Map<K, Collection<V>> zzs() {
        Map<K, Collection<V>> map = this.zzc;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzj = zzj();
        this.zzc = zzj;
        return zzj;
    }

    public final Set<K> zzt() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> zzl = zzl();
        this.zza = zzl;
        return zzl;
    }

    public boolean zzu(@CheckForNull Object obj) {
        for (Collection contains : zzs().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
