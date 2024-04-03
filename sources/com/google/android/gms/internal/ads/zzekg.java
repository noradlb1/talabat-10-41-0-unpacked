package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzekg implements zzehv<zzfev, zzejp> {
    private final zzdww zza;

    public zzekg(zzdww zzdww) {
        this.zza = zzdww;
    }

    public final zzehw<zzfev, zzejp> zza(String str, JSONObject jSONObject) throws zzfek {
        return new zzehw<>(this.zza.zzb(str, jSONObject), new zzejp(), str);
    }
}
