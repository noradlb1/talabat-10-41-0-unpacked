package com.google.android.gms.internal.ads;

import java.io.Serializable;

final class zzfso<K, V> extends zzfrn<K, V> implements Serializable {
    final K zza;
    final V zzb;

    public zzfso(K k11, V v11) {
        this.zza = k11;
        this.zzb = v11;
    }

    public final K getKey() {
        return this.zza;
    }

    public final V getValue() {
        return this.zzb;
    }

    public final V setValue(V v11) {
        throw new UnsupportedOperationException();
    }
}
