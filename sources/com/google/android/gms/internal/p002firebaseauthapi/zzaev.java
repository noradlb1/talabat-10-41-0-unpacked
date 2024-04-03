package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaev  reason: invalid package */
public final class zzaev implements zzaaz {
    private final String zza;
    @Nullable
    private final String zzb;

    public zzaev(String str, @Nullable String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LegacyTokenLocalDataSourceImpl.KEY, (Object) this.zza);
        jSONObject.put("returnSecureToken", true);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
