package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final class zzebn {
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final String zzd;
    private final int zze;

    public zzebn(String str, String str2, int i11, String str3, int i12) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
        this.zzd = str3;
        this.zze = i12;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", (Object) this.zza);
        jSONObject.put("version", (Object) this.zzb);
        jSONObject.put("status", this.zzc);
        jSONObject.put("description", (Object) this.zzd);
        jSONObject.put("initializationLatencyMillis", this.zze);
        return jSONObject;
    }
}
