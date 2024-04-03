package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeb  reason: invalid package */
public final class zzaeb implements zzaaz {
    private final String zza;
    private final long zzb;
    private final boolean zzc;
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final String zzf;
    @Nullable
    private final String zzg;
    private final boolean zzh;
    @Nullable
    private zzaco zzi;

    public zzaeb(String str, long j11, boolean z11, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z12) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = j11;
        this.zzc = z11;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = str4;
        this.zzg = str5;
        this.zzh = z12;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (Object) this.zza);
        String str = this.zze;
        if (str != null) {
            jSONObject.put("tenantId", (Object) str);
        }
        String str2 = this.zzf;
        if (str2 != null) {
            jSONObject.put("recaptchaToken", (Object) str2);
        }
        zzaco zzaco = this.zzi;
        if (zzaco != null) {
            jSONObject.put("autoRetrievalInfo", (Object) zzaco.zza());
        }
        String str3 = this.zzg;
        if (str3 != null) {
            jSONObject.put("playIntegrityToken", (Object) str3);
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zza;
    }

    public final void zze(zzaco zzaco) {
        this.zzi = zzaco;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return this.zzh;
    }
}
