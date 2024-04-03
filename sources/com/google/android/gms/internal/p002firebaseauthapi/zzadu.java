package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadu  reason: invalid package */
public final class zzadu {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;

    public static zzadu zza(String str) throws UnsupportedEncodingException {
        try {
            zzadu zzadu = new zzadu();
            JSONObject jSONObject = new JSONObject(str);
            zzadu.zza = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_ISS);
            zzadu.zzb = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_AUD);
            zzadu.zzc = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_SUB);
            zzadu.zzd = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_IAT));
            zzadu.zze = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_EXP));
            jSONObject.optBoolean("is_anonymous");
            return zzadu;
        } catch (JSONException e11) {
            if (Log.isLoggable("JwtToken", 3)) {
                "Failed to read JwtToken from JSONObject. ".concat(e11.toString());
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. ".concat(e11.toString()));
        }
    }

    public final Long zzb() {
        return this.zze;
    }

    public final Long zzc() {
        return this.zzd;
    }
}
