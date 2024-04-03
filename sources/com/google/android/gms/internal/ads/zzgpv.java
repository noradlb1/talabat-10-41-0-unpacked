package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzgpv<K, V> extends zzgpn<K, V, V> {
    private static final zzgqe<Map<Object, Object>> zza = zzgps.zza(Collections.emptyMap());

    public /* synthetic */ zzgpv(Map map, zzgpt zzgpt) {
        super(map);
    }

    public static <K, V> zzgpu<K, V> zzc(int i11) {
        return new zzgpu<>(i11, (zzgpt) null);
    }

    /* renamed from: zzd */
    public final Map<K, V> zzb() {
        LinkedHashMap zzb = zzgpo.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzb.put(entry.getKey(), ((zzgqe) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzb);
    }
}
