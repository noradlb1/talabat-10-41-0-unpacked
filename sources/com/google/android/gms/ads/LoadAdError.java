package com.google.android.gms.ads;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class LoadAdError extends AdError {
    @Nullable
    private final ResponseInfo zza;

    public LoadAdError(int i11, @RecentlyNonNull String str, @RecentlyNonNull String str2, @Nullable AdError adError, @Nullable ResponseInfo responseInfo) {
        super(i11, str, str2, adError);
        this.zza = responseInfo;
    }

    @RecentlyNullable
    public ResponseInfo getResponseInfo() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzge)).booleanValue()) {
            return this.zza;
        }
        return null;
    }

    @RecentlyNonNull
    public String toString() {
        try {
            JSONObject zzb = zzb();
            return !(zzb instanceof JSONObject) ? zzb.toString(2) : JSONObjectInstrumentation.toString(zzb, 2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zzb() throws JSONException {
        JSONObject zzb = super.zzb();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzb.put("Response Info", (Object) "null");
        } else {
            zzb.put("Response Info", (Object) responseInfo.zzc());
        }
        return zzb;
    }
}
