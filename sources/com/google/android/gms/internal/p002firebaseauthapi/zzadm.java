package com.google.android.gms.internal.p002firebaseauthapi;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadm  reason: invalid package */
public final class zzadm implements zzaaz {
    public static zzadm zzb() {
        return new zzadm();
    }

    public final String zza() throws JSONException {
        return JSONObjectInstrumentation.toString(new JSONObject());
    }
}
