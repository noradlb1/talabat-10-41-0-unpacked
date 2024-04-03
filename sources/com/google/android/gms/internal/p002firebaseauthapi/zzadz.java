package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadz  reason: invalid package */
public final class zzadz implements zzaaz {
    private final String zza;
    @Nullable
    private final String zzb;
    @Nullable
    private final String zzc;

    public zzadz(String str, @Nullable String str2, @Nullable String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = str3;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oobCode", (Object) this.zza);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put(HintConstants.AUTOFILL_HINT_NEW_PASSWORD, (Object) str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            jSONObject.put("tenantId", (Object) str2);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
