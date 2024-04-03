package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacu  reason: invalid package */
public final class zzacu implements zzaaz {
    private static final String zza = "zzacu";
    private static final Logger zzb = new Logger(zzacu.class.getSimpleName(), new String[0]);
    private final String zzc;
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final String zzf;

    public zzacu(EmailAuthCredential emailAuthCredential, @Nullable String str, @Nullable String str2) {
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzd());
        this.zzd = Preconditions.checkNotEmpty(emailAuthCredential.zzf());
        this.zze = str;
        this.zzf = str2;
    }

    public final String zza() throws JSONException {
        String str;
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzd);
        String str2 = null;
        if (parseLink != null) {
            str = parseLink.getCode();
        } else {
            str = null;
        }
        if (parseLink != null) {
            str2 = parseLink.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", (Object) this.zzc);
        if (str != null) {
            jSONObject.put("oobCode", (Object) str);
        }
        if (str2 != null) {
            jSONObject.put("tenantId", (Object) str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("idToken", (Object) str3);
        }
        String str4 = this.zzf;
        if (str4 != null) {
            zzafd.zzd(jSONObject, "captchaResp", str4);
        } else {
            zzafd.zzc(jSONObject);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
