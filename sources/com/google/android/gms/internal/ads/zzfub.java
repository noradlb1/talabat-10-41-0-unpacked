package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzfub<K, V> extends zzfqv<K, V> {
    final transient zzfqs<? extends List<V>> zza;

    public zzfub(Map<K, Collection<V>> map, zzfqs<? extends List<V>> zzfqs) {
        super(map);
        this.zza = zzfqs;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Collection, java.lang.Object] */
    public final /* bridge */ /* synthetic */ Collection zza() {
        return this.zza.zza();
    }

    public final Map<K, Collection<V>> zzj() {
        return zzk();
    }

    public final Set<K> zzl() {
        return zzm();
    }
}
