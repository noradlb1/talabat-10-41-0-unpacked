package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaem  reason: invalid package */
public final class zzaem extends zzaei {
    private static final String zza = "zzaem";
    @Nullable
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        zzd(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzaei zzb(String str) throws zzyq {
        zzd(str);
        return this;
    }

    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    public final zzaem zzd(String str) throws zzyq {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }
}
