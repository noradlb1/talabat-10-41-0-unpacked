package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzsc<K, V> {
    public static <K, V> void zza(zzqj zzqj, zzsd<K, V> zzsd, K k11, V v11) throws IOException {
        zzqt.zza(zzqj, zzsd.zzbcp, 1, k11);
        zzqt.zza(zzqj, zzsd.zzbcr, 2, v11);
    }

    public static <K, V> int zza(zzsd<K, V> zzsd, K k11, V v11) {
        return zzqt.zza(zzsd.zzbcp, 1, k11) + zzqt.zza(zzsd.zzbcr, 2, v11);
    }
}
