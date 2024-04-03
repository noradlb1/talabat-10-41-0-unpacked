package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzexd implements zzevm<JSONObject> {
    private final String zza;
    private final String zzb;

    public zzexd(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            JSONObject zzf = zzby.zzf((JSONObject) obj, "pii");
            zzf.put("doritos", (Object) this.zza);
            zzf.put("doritos_v2", (Object) this.zzb);
        } catch (JSONException unused) {
            zze.zza("Failed putting doritos string.");
        }
    }
}
