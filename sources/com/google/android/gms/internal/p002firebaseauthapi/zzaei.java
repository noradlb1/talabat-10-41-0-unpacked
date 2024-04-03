package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaei  reason: invalid package */
public class zzaei implements zzaba {
    private static final String zza = "zzaei";

    /* renamed from: zzb */
    public zzaei zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                zzaem zzaem = new zzaem();
                zzaem.zzd(str);
                return zzaem;
            } else if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                zzaeo zzaeo = new zzaeo();
                zzaeo.zzg(str);
                return zzaeo;
            } else {
                throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
            }
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    @Nullable
    public String zzc() {
        return null;
    }
}
