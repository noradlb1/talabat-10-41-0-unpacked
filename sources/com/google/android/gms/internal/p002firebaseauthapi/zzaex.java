package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaex  reason: invalid package */
public final class zzaex implements zzaaz {
    private final String zza;
    private final String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;

    public zzaex(String str, String str2, @Nullable String str3, @Nullable String str4) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", (Object) this.zza);
        jSONObject.put("password", (Object) this.zzb);
        jSONObject.put("returnSecureToken", true);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            zzafd.zzd(jSONObject, "captchaResponse", str2);
        } else {
            zzafd.zzc(jSONObject);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
