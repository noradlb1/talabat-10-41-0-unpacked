package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacs  reason: invalid package */
public final class zzacs implements zzaba {
    private static final String zza = "zzacs";
    private String zzb;
    private String zzc;
    private zzaep zzd = new zzaep((List) null);
    private List zze;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", (String) null);
            jSONObject.optBoolean("registered", false);
            this.zzc = jSONObject.optString("providerId", (String) null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzd = new zzaep(1, zzafd.zzb(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzd = new zzaep((List) null);
            }
            this.zze = zzafd.zzb(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    @Nullable
    public final List zzb() {
        return this.zze;
    }
}
