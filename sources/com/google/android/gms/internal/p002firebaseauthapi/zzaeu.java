package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zze;
import com.visa.checkout.Profile;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeu  reason: invalid package */
public final class zzaeu implements zzaba {
    private static final String zza = "zzaeu";
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private boolean zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private List zzs;
    private String zzt;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            jSONObject.optBoolean("needEmail", false);
            this.zzc = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zze = jSONObject.optLong("expiresIn", 0);
            this.zzf = Strings.emptyToNull(jSONObject.optString("localId", (String) null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("email", (String) null));
            this.zzh = Strings.emptyToNull(jSONObject.optString(Profile.DISPLAY_NAME, (String) null));
            this.zzi = Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null));
            this.zzj = Strings.emptyToNull(jSONObject.optString("providerId", (String) null));
            this.zzk = Strings.emptyToNull(jSONObject.optString("rawUserInfo", (String) null));
            this.zzl = jSONObject.optBoolean("isNewUser", false);
            this.zzm = jSONObject.optString("oauthAccessToken", (String) null);
            this.zzn = jSONObject.optString("oauthIdToken", (String) null);
            this.zzp = Strings.emptyToNull(jSONObject.optString("errorMessage", (String) null));
            this.zzq = Strings.emptyToNull(jSONObject.optString("pendingToken", (String) null));
            this.zzr = Strings.emptyToNull(jSONObject.optString("tenantId", (String) null));
            this.zzs = zzadv.zzg(jSONObject.optJSONArray("mfaInfo"));
            this.zzt = Strings.emptyToNull(jSONObject.optString("mfaPendingCredential", (String) null));
            this.zzo = Strings.emptyToNull(jSONObject.optString("oauthTokenSecret", (String) null));
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        return this.zze;
    }

    @Nullable
    public final zze zzc() {
        if (!TextUtils.isEmpty(this.zzm) || !TextUtils.isEmpty(this.zzn)) {
            return zze.zzc(this.zzj, this.zzn, this.zzm, this.zzq, this.zzo);
        }
        return null;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String zzg() {
        return this.zzt;
    }

    public final String zzh() {
        return this.zzj;
    }

    public final String zzi() {
        return this.zzk;
    }

    @Nullable
    public final String zzj() {
        return this.zzd;
    }

    @Nullable
    public final String zzk() {
        return this.zzr;
    }

    public final List zzl() {
        return this.zzs;
    }

    public final boolean zzm() {
        return !TextUtils.isEmpty(this.zzt);
    }

    public final boolean zzn() {
        return this.zzb;
    }

    public final boolean zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        return this.zzb || !TextUtils.isEmpty(this.zzp);
    }
}
