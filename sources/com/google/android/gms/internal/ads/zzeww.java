package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzeww implements zzevm<JSONObject> {
    private final JSONObject zza;

    public zzeww(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", (Object) this.zza);
        } catch (JSONException unused) {
            zze.zza("Unable to get cache_state");
        }
    }
}
