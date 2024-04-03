package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.tekartik.sqflite.Constant;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaez  reason: invalid package */
public final class zzaez implements zzaaz {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzaez() {
    }

    public static zzaez zzb(String str, String str2, boolean z11) {
        zzaez zzaez = new zzaez();
        zzaez.zzb = Preconditions.checkNotEmpty(str);
        zzaez.zzc = Preconditions.checkNotEmpty(str2);
        zzaez.zzf = z11;
        return zzaez;
    }

    public static zzaez zzc(String str, String str2, boolean z11) {
        zzaez zzaez = new zzaez();
        zzaez.zza = Preconditions.checkNotEmpty(str);
        zzaez.zzd = Preconditions.checkNotEmpty(str2);
        zzaez.zzf = z11;
        return zzaez;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zza);
            jSONObject.put("temporaryProof", (Object) this.zzd);
        } else {
            jSONObject.put("sessionInfo", (Object) this.zzb);
            jSONObject.put(Constant.PARAM_ERROR_CODE, (Object) this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", (Object) str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
