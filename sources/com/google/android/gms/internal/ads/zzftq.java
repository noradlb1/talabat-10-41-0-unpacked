package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

abstract class zzftq<K, V> extends AbstractMap<K, V> {
    @CheckForNull
    private transient Set<Map.Entry<K, V>> zza;
    @CheckForNull
    private transient Set<K> zzb;
    @CheckForNull
    private transient Collection<V> zzc;

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> zzb2 = zzb();
        this.zza = zzb2;
        return zzb2;
    }

    public Set<K> keySet() {
        Set<K> set = this.zzb;
        if (set != null) {
            return set;
        }
        Set<K> zze = zze();
        this.zzb = zze;
        return zze;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzftp zzftp = new zzftp(this);
        this.zzc = zzftp;
        return zzftp;
    }

    public abstract Set<Map.Entry<K, V>> zzb();

    public Set<K> zze() {
        return new zzfto(this);
    }
}
