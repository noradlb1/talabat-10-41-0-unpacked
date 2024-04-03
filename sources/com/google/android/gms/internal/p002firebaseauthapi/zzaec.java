package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaec  reason: invalid package */
public final class zzaec implements zzaba {
    private static final String zza = "zzaec";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("sessionInfo", (String) null));
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }
}
