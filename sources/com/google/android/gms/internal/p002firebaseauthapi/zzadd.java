package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadd  reason: invalid package */
public final class zzadd implements zzacy {
    private final String zza = Preconditions.checkNotEmpty(TotpMultiFactorGenerator.FACTOR_ID);
    private final String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;

    @VisibleForTesting
    public zzadd(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
    }

    public static zzadd zzb(String str, String str2, @Nullable String str3, String str4) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str4);
        return new zzadd(TotpMultiFactorGenerator.FACTOR_ID, str, str2, str3, str4);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = this.zzc;
        if (str != null) {
            jSONObject2.put("verificationCode", (Object) str);
        }
        jSONObject.put("totpVerificationInfo", (Object) jSONObject2);
        jSONObject.put("mfaPendingCredential", (Object) this.zzb);
        String str2 = this.zzd;
        if (str2 != null) {
            jSONObject.put("tenantId", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("mfaEnrollmentId", (Object) str3);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
