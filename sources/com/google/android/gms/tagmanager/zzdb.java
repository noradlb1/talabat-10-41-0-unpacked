package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
final class zzdb<K, V> implements zzp<K, V> {
    private LruCache<K, V> zzahy;

    public zzdb(int i11, zzs<K, V> zzs) {
        this.zzahy = new zzdc(this, 1048576, zzs);
    }

    public final V get(K k11) {
        return this.zzahy.get(k11);
    }

    public final void zza(K k11, V v11) {
        this.zzahy.put(k11, v11);
    }
}
