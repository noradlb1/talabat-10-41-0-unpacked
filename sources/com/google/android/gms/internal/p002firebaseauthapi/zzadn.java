package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadn  reason: invalid package */
public final class zzadn implements zzaba {
    private static final String zza = "zzadn";
    @Nullable
    private String zzb;

    public zzadn() {
    }

    public zzadn(String str) {
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
