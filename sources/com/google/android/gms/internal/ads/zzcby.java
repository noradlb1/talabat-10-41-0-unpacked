package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

public final class zzcby {
    public final boolean zza;
    public final String zzb;

    public zzcby(boolean z11, String str) {
        this.zza = z11;
        this.zzb = str;
    }

    @Nullable
    public static zzcby zza(JSONObject jSONObject) {
        return new zzcby(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
