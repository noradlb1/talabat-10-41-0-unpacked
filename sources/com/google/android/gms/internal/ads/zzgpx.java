package com.google.android.gms.internal.ads;

import com.google.firebase.perf.metrics.resource.ResourceType;

public final class zzgpx<K, V> extends zzgpm<K, V, zzgqe<V>> {
    public /* synthetic */ zzgpx(int i11, zzgpw zzgpw) {
        super(1);
    }

    public final zzgpx<K, V> zzb(K k11, zzgqe<V> zzgqe) {
        super.zza(ResourceType.NETWORK, zzgqe);
        return this;
    }

    public final zzgpy<K, V> zzc() {
        return new zzgpy<>(this.zza, (zzgpw) null);
    }
}
