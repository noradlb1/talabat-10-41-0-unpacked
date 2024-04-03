package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzewj implements zzevm<JSONObject> {
    private final String zza;

    public zzewj(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            ((JSONObject) obj).put("ms", (Object) this.zza);
        } catch (JSONException e11) {
            zze.zzb("Failed putting Ad ID.", e11);
        }
    }
}
