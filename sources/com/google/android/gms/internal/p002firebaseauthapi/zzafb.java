package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafb  reason: invalid package */
public final class zzafb implements zzaaz {
    private final String zza;
    private final String zzb;
    @Nullable
    private final String zzc;

    public zzafb(String str, String str2, @Nullable String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        jSONObject.put("mfaEnrollmentId", (Object) this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
