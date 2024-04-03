package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbrv implements zzbrt<zzcop> {
    private final zzbrw zza;

    public zzbrv(zzbrw zzbrw, byte[] bArr) {
        this.zza = zzbrw;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f11 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f11 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e11) {
            zzciz.zzh("Fail to parse float", e11);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f11);
        zzcop.zzav(equals);
    }
}
