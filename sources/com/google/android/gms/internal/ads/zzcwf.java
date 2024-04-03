package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class zzcwf implements zzcvs {
    private final zzcgk zza;

    public zzcwf(zzcgk zzcgk) {
        this.zza = zzcgk;
    }

    public final void zza(JSONObject jSONObject) {
        int i11;
        long optLong = jSONObject.optLong("timestamp");
        if (jSONObject.optBoolean("npa_reset")) {
            i11 = -1;
        } else {
            i11 = jSONObject.optBoolean("npa");
        }
        this.zza.zzb(i11, optLong);
    }
}
