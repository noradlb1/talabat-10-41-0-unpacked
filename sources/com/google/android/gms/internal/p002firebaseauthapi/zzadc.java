package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadc  reason: invalid package */
public final class zzadc implements zzacw {
    private String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    @Nullable
    private final String zze;

    @VisibleForTesting
    public zzadc(String str, String str2, String str3, String str4, @Nullable String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = Preconditions.checkNotEmpty(str3);
        this.zzd = Preconditions.checkNotEmpty(str4);
        this.zze = str5;
    }

    public static zzadc zzc(String str, String str2, String str3, String str4, @Nullable String str5) {
        return new zzadc(str, str2, str3, str4, str5);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put(Profile.DISPLAY_NAME, (Object) this.zzb);
        }
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.zzc)) {
            jSONObject2.put("sessionInfo", (Object) this.zzc);
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject2.put("verificationCode", (Object) this.zzd);
        }
        jSONObject.put("totpVerificationInfo", (Object) jSONObject2);
        if (!TextUtils.isEmpty(this.zze)) {
            jSONObject.put("tenantId", (Object) this.zze);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final /* synthetic */ zzacw zzb(String str) {
        this.zza = str;
        return this;
    }
}
