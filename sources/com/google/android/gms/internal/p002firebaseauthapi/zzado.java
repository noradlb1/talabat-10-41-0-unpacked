package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzado  reason: invalid package */
public final class zzado implements zzaba {
    private static final String zza = "zzado";
    private List zzb;

    public final /* bridge */ /* synthetic */ zzaba zza(String str) throws zzyq {
        zzb(str);
        return this;
    }

    public final zzado zzb(String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    this.zzb.add(optJSONArray.getString(i11));
                }
            }
            return this;
        } catch (JSONException e11) {
            throw zzafd.zza(e11, zza, str);
        }
    }

    public final List zzc() {
        return this.zzb;
    }
}
