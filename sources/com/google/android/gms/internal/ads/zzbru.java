package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

public final class zzbru implements zzbrt<Object> {
    private final zzebt zza;

    public zzbru(zzebt zzebt) {
        Preconditions.checkNotNull(zzebt, "The Inspector Manager must not be null");
        this.zza = zzebt;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (map != null && map.containsKey("extras")) {
            long j11 = Long.MAX_VALUE;
            if (map.containsKey("expires")) {
                try {
                    j11 = Long.parseLong(map.get("expires"));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzh(map.get("extras"), j11);
        }
    }
}
