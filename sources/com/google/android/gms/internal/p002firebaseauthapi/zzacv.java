package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacv  reason: invalid package */
public final class zzacv implements zzaba {
    private static final String zza = "zzacv";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private long zzg;
    @Nullable
    private List zzh;
    @Nullable
    private String zzi;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("localId", (String) null);
            this.zzc = jSONObject.optString("email", (String) null);
            this.zzd = jSONObject.optString("idToken", (String) null);
            this.zze = jSONObject.optString("refreshToken", (String) null);
            this.zzf = jSONObject.optBoolean("isNewUser", false);
            this.zzg = jSONObject.optLong("expiresIn", 0);
            this.zzh = zzadv.zzg(jSONObject.optJSONArray("mfaInfo"));
            this.zzi = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final long zzb() {
        return this.zzg;
    }

    @NonNull
    public final String zzc() {
        return this.zzd;
    }

    @Nullable
    public final String zzd() {
        return this.zzi;
    }

    @NonNull
    public final String zze() {
        return this.zze;
    }

    @Nullable
    public final List zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzi);
    }

    public final boolean zzh() {
        return this.zzf;
    }
}
