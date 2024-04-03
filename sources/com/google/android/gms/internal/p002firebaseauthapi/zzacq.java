package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tekartik.sqflite.Constant;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacq  reason: invalid package */
public final class zzacq implements zzaba {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzacq";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaba zza(@NonNull String str) throws zzyq {
        zzb(str);
        return this;
    }

    public final zzacq zzb(@NonNull String str) throws zzyq {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt(Constant.PARAM_ERROR_CODE);
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e11) {
            String str2 = zza;
            String message = e11.getMessage();
            Log.e(str2, "Failed to parse error for string [" + str + "] with exception: " + message);
            throw new zzyq("Failed to parse error for string [" + str + "]", e11);
        }
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
