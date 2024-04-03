package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafa  reason: invalid package */
public final class zzafa implements zzaba {
    private static final String zza = "zzafa";
    private String zzb;
    private String zzc;
    private long zzd;
    private String zze;
    private boolean zzf;
    private String zzg;
    private String zzh;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzd = jSONObject.optLong("expiresIn", 0);
            this.zze = Strings.emptyToNull(jSONObject.optString("localId", (String) null));
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = Strings.emptyToNull(jSONObject.optString("temporaryProof", (String) null));
            this.zzh = Strings.emptyToNull(jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, (String) null));
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        return this.zzd;
    }

    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    @Nullable
    public final String zzd() {
        return this.zzh;
    }

    @Nullable
    public final String zze() {
        return this.zzc;
    }

    @Nullable
    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
