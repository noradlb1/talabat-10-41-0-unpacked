package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzf implements Callable {
    private final zzi zza;
    private final String zzb;
    private final JSONObject zzc;

    public zzf(zzi zzi, String str, JSONObject jSONObject) {
        this.zza = zzi;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final Object call() {
        return Boolean.valueOf(this.zza.zza(this.zzb, this.zzc));
    }
}
