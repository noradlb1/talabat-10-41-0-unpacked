package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

final class zzftu extends zzfty {
    final /* synthetic */ Comparator zza;

    public zzftu(Comparator comparator) {
        this.zza = comparator;
    }

    public final <K, V> Map<K, Collection<V>> zza() {
        return new TreeMap(this.zza);
    }
}
