package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzemm implements zzehv<zzbzo, zzejp> {
    private final zzenq zza;

    public zzemm(zzenq zzenq) {
        this.zza = zzenq;
    }

    public final zzehw<zzbzo, zzejp> zza(String str, JSONObject jSONObject) throws zzfek {
        zzbzo zza2 = this.zza.zza(str);
        if (zza2 == null) {
            return null;
        }
        return new zzehw<>(zza2, new zzejp(), str);
    }
}
