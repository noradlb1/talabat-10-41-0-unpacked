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
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaej  reason: invalid package */
public final class zzaej implements zzaaz {
    private final String zza = Preconditions.checkNotEmpty("phone");
    private final String zzb;
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final String zzf;
    @Nullable
    private final String zzg;
    @Nullable
    private zzaco zzh;

    private zzaej(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = Preconditions.checkNotEmpty(str3);
        this.zze = str4;
        this.zzd = str5;
        this.zzf = str6;
        this.zzg = str7;
    }

    public static zzaej zzb(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Preconditions.checkNotEmpty(str3);
        return new zzaej("phone", str, str2, str3, str4, str5, str6);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mfaPendingCredential", (Object) this.zzb);
        jSONObject.put("mfaEnrollmentId", (Object) this.zzc);
        this.zza.hashCode();
        jSONObject.put("mfaProvider", 1);
        if (this.zze != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zze);
            if (!TextUtils.isEmpty(this.zzf)) {
                jSONObject2.put("recaptchaToken", (Object) this.zzf);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject2.put("playIntegrityToken", (Object) this.zzg);
            }
            zzaco zzaco = this.zzh;
            if (zzaco != null) {
                jSONObject2.put("autoRetrievalInfo", (Object) zzaco.zza());
            }
            jSONObject.put("phoneSignInInfo", (Object) jSONObject2);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @Nullable
    public final String zzc() {
        return this.zzd;
    }

    public final void zzd(zzaco zzaco) {
        this.zzh = zzaco;
    }
}
