package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadg  reason: invalid package */
public final class zzadg implements zzaaz {
    private final String zza;

    public zzadg(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
