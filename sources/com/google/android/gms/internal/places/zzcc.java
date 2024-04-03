package com.google.android.gms.internal.places;

import java.io.IOException;

public final class zzcc<K, V> {
    public static <K, V> void zzb(zzaj zzaj, zzcb<K, V> zzcb, K k11, V v11) throws IOException {
        zzav.zzb(zzaj, zzcb.zzkj, 1, k11);
        zzav.zzb(zzaj, zzcb.zzkl, 2, v11);
    }

    public static <K, V> int zzb(zzcb<K, V> zzcb, K k11, V v11) {
        return zzav.zzb(zzcb.zzkj, 1, k11) + zzav.zzb(zzcb.zzkl, 2, v11);
    }
}
