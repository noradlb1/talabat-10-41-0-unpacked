package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.agconnect.credential.Server;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.flutter.plugins.firebase.crashlytics.Constants;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacr  reason: invalid package */
public final class zzacr implements zzaaz {
    private final String zza;
    private final String zzb = Server.GW;
    @Nullable
    private final String zzc;

    public zzacr(String str, @Nullable String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.IDENTIFIER, (Object) this.zza);
        jSONObject.put("continueUri", (Object) this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
