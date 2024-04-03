package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

final class zzewz implements zzevn<zzevm<JSONObject>> {
    private final JSONObject zza;

    public zzewz(Context context) {
        this.zza = zzcea.zzc(context);
    }

    public final /* synthetic */ void zza(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", (Object) this.zza);
        } catch (JSONException unused) {
            zze.zza("Failed putting version constants.");
        }
    }

    public final zzfxa<zzevm<JSONObject>> zzb() {
        return zzfwq.zzi(new zzewy(this));
    }
}
