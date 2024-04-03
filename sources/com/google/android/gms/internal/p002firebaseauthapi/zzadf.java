package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadf  reason: invalid package */
public final class zzadf implements zzaaz {
    private final String zza = zzade.REFRESH_TOKEN.toString();
    private final String zzb;

    public zzadf(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", (Object) this.zza);
        jSONObject.put("refreshToken", (Object) this.zzb);
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
