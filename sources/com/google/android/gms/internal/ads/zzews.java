package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzews implements zzevm<JSONObject> {
    private final String zza;

    public zzews(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            JSONObject zzf = zzby.zzf((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zza)) {
                zzf.put("attok", (Object) this.zza);
            }
        } catch (JSONException e11) {
            zze.zzb("Failed putting attestation token.", e11);
        }
    }
}
