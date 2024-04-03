package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.visa.checkout.Profile;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaey  reason: invalid package */
public final class zzaey implements zzaba {
    private static final String zza = "zzaey";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private List zzi;
    private String zzj;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("localId", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString(Profile.DISPLAY_NAME, (String) null));
            this.zze = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzf = Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzh = jSONObject.optLong("expiresIn", 0);
            this.zzi = zzadv.zzg(jSONObject.optJSONArray("mfaInfo"));
            this.zzj = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    @NonNull
    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzj;
    }

    @NonNull
    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzj);
    }
}
