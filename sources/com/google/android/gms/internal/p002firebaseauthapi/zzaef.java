package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaef  reason: invalid package */
public final class zzaef implements zzaaz {
    private String zza;
    private String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private String zzd;

    public zzaef(@Nullable String str) {
        this.zzc = str;
    }

    public zzaef(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str4;
        this.zzd = str5;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        if (str != null) {
            jSONObject.put("email", (Object) str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("password", (Object) str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("tenantId", (Object) str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            zzafd.zzd(jSONObject, "captchaResponse", str4);
        } else {
            zzafd.zzc(jSONObject);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
