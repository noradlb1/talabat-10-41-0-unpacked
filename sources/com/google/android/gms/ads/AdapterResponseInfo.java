package com.google.android.gms.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzbfm;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class AdapterResponseInfo {
    private final zzbfm zza;
    @Nullable
    private final AdError zzb;

    private AdapterResponseInfo(zzbfm zzbfm) {
        this.zza = zzbfm;
        zzbew zzbew = zzbfm.zzc;
        this.zzb = zzbew == null ? null : zzbew.zza();
    }

    @Nullable
    public static AdapterResponseInfo zza(@Nullable zzbfm zzbfm) {
        if (zzbfm != null) {
            return new AdapterResponseInfo(zzbfm);
        }
        return null;
    }

    @RecentlyNullable
    public AdError getAdError() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getAdapterClassName() {
        return this.zza.zza;
    }

    @RecentlyNonNull
    public Bundle getCredentials() {
        return this.zza.zzd;
    }

    public long getLatencyMillis() {
        return this.zza.zzb;
    }

    @RecentlyNonNull
    public String toString() {
        try {
            JSONObject zzb2 = zzb();
            return !(zzb2 instanceof JSONObject) ? zzb2.toString(2) : JSONObjectInstrumentation.toString(zzb2, 2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", (Object) this.zza.zza);
        jSONObject.put("Latency", this.zza.zzb);
        JSONObject jSONObject2 = new JSONObject();
        for (String next : this.zza.zzd.keySet()) {
            jSONObject2.put(next, this.zza.zzd.get(next));
        }
        jSONObject.put("Credentials", (Object) jSONObject2);
        AdError adError = this.zzb;
        if (adError == null) {
            jSONObject.put("Ad Error", (Object) "null");
        } else {
            jSONObject.put("Ad Error", (Object) adError.zzb());
        }
        return jSONObject;
    }
}
