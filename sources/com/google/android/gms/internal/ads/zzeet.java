package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final /* synthetic */ class zzeet implements zzfhh {
    public static final /* synthetic */ zzeet zza = new zzeet();

    private /* synthetic */ zzeet() {
    }

    public final Object zza(Object obj) {
        String str;
        JSONObject jSONObject = (JSONObject) obj;
        zze.zza("Ad request signals:");
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString(2);
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject, 2);
        }
        zze.zza(str);
        return jSONObject;
    }
}
