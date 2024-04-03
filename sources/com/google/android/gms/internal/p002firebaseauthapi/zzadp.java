package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadp  reason: invalid package */
public final class zzadp implements zzaaz {
    @Nullable
    private final String zza;
    private final String zzb = "CLIENT_TYPE_ANDROID";
    private final String zzc = "RECAPTCHA_ENTERPRISE";

    private zzadp(@Nullable String str, String str2) {
        this.zza = str;
    }

    public static zzadp zzb(@Nullable String str, String str2) {
        return new zzadp(str, "RECAPTCHA_ENTERPRISE");
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zza)) {
            jSONObject.put("tenantId", (Object) this.zza);
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("clientType", (Object) this.zzb);
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject.put("recaptchaVersion", (Object) this.zzc);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
