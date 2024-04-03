package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzby;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzexx implements zzevm<JSONObject> {
    private final String zza;

    public zzexx(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (!TextUtils.isEmpty(this.zza)) {
                zzby.zzf(jSONObject, "pii").put("adsid", (Object) this.zza);
            }
        } catch (JSONException e11) {
            zzciz.zzk("Failed putting trustless token.", e11);
        }
    }
}
