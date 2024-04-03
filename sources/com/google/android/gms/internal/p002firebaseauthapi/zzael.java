package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzael  reason: invalid package */
public final class zzael implements zzaeh {
    private final String zza;
    private final String zzb = Preconditions.checkNotEmpty("phone");
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final String zzf;
    @Nullable
    private zzaco zzg;

    private zzael(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
    }

    public static zzael zzb(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Preconditions.checkNotEmpty(str2);
        return new zzael(str, "phone", str2, str3, str4, str5, (String) null);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", (Object) this.zza);
        jSONObject.put("mfaProvider", 1);
        if (this.zzc != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zzc);
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("recaptchaToken", (Object) this.zze);
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("playIntegrityToken", (Object) this.zzf);
            }
            zzaco zzaco = this.zzg;
            if (zzaco != null) {
                jSONObject2.put("autoRetrievalInfo", (Object) zzaco.zza());
            }
            jSONObject.put("phoneEnrollmentInfo", (Object) jSONObject2);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            jSONObject.put("tenantId", (Object) null);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @Nullable
    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzaco zzaco) {
        this.zzg = zzaco;
    }
}
