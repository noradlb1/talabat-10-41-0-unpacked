package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.tekartik.sqflite.Constant;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadb  reason: invalid package */
public final class zzadb implements zzacy {
    private final String zza = Preconditions.checkNotEmpty("phone");
    private final String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;

    @VisibleForTesting
    public zzadb(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
    }

    public static zzadb zzb(String str, String str2, String str3, @Nullable String str4) {
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotEmpty(str2);
        return new zzadb("phone", str, str2, str3, str4);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaProvider", 1);
        JSONObject jSONObject2 = new JSONObject();
        String str = this.zzc;
        if (str != null) {
            jSONObject2.put("sessionInfo", (Object) str);
        }
        String str2 = this.zzd;
        if (str2 != null) {
            jSONObject2.put(Constant.PARAM_ERROR_CODE, (Object) str2);
        }
        jSONObject.put("phoneVerificationInfo", (Object) jSONObject2);
        jSONObject.put("mfaPendingCredential", (Object) this.zzb);
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("tenantId", (Object) str3);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
