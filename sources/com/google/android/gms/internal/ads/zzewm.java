package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzewm implements zzevm<JSONObject> {
    private final JSONObject zza;

    public zzewm(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            JSONObject zzf = zzby.zzf((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zza;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzf.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zze.zza("Failed putting app indexing json.");
        }
    }
}
