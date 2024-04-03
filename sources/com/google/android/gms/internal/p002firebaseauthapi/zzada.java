package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.tekartik.sqflite.Constant;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzada  reason: invalid package */
public final class zzada implements zzacw {
    private final String zza = Preconditions.checkNotEmpty("phone");
    private String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final String zzf;

    private zzada(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzd = str3;
        this.zze = str4;
        this.zzc = str5;
        this.zzf = str6;
    }

    public static zzada zzc(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotEmpty(str2);
        return new zzada("phone", str, str2, str3, str4, str5);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zzb);
        jSONObject.put("mfaProvider", 1);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put(Profile.DISPLAY_NAME, (Object) str);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str2 = this.zzd;
        if (str2 != null) {
            jSONObject2.put("sessionInfo", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject2.put(Constant.PARAM_ERROR_CODE, (Object) str3);
        }
        jSONObject.put("phoneVerificationInfo", (Object) jSONObject2);
        String str4 = this.zzf;
        if (str4 != null) {
            jSONObject.put("tenantId", (Object) str4);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final /* synthetic */ zzacw zzb(String str) {
        this.zzb = str;
        return this;
    }
}
