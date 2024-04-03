package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaen  reason: invalid package */
public final class zzaen implements zzaeh {
    private final String zza;
    @Nullable
    private final String zzb;

    private zzaen(String str, @Nullable String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
    }

    public static zzaen zzb(String str, @Nullable String str2) {
        return new zzaen(str, str2);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("tenantId", (Object) this.zzb);
        }
        jSONObject.put("totpEnrollmentInfo", (Object) new JSONObject());
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
