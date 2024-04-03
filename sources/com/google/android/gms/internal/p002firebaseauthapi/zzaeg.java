package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.visa.checkout.Profile;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeg  reason: invalid package */
public final class zzaeg implements zzaba {
    private static final String zza = "zzaeg";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString(Profile.DISPLAY_NAME, (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zze = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzf = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzb;
    }

    @NonNull
    public final String zzd() {
        return this.zze;
    }
}
