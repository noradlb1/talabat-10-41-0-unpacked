package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

public class zzgpm<K, V, V2> {
    final LinkedHashMap<K, zzgqe<V>> zza;

    public zzgpm(int i11) {
        this.zza = zzgpo.zzb(i11);
    }

    public final zzgpm<K, V, V2> zza(K k11, zzgqe<V> zzgqe) {
        LinkedHashMap<K, zzgqe<V>> linkedHashMap = this.zza;
        zzgpz.zza(k11, "key");
        zzgpz.zza(zzgqe, "provider");
        linkedHashMap.put(k11, zzgqe);
        return this;
    }
}
