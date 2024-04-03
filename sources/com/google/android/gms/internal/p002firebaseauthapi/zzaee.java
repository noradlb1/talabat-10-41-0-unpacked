package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.visa.checkout.Profile;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaee  reason: invalid package */
public final class zzaee implements zzaba {
    private static final String zza = "zzaee";
    private String zzb;
    private String zzc;
    private Boolean zzd;
    private String zze;
    private String zzf;
    private zzadx zzg;
    private String zzh;
    private String zzi;
    private long zzj;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("passwordHash", (String) null));
            this.zzd = Boolean.valueOf(jSONObject.optBoolean("emailVerified", false));
            this.zze = Strings.emptyToNull(jSONObject.optString(Profile.DISPLAY_NAME, (String) null));
            this.zzf = Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null));
            this.zzg = zzadx.zza(jSONObject.optJSONArray("providerUserInfo"));
            this.zzh = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzi = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzj = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        return this.zzj;
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
        return this.zzi;
    }

    @Nullable
    public final List zzf() {
        zzadx zzadx = this.zzg;
        if (zzadx != null) {
            return zzadx.zzc();
        }
        return null;
    }
}
