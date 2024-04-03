package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafd  reason: invalid package */
public final class zzafd {
    @NonNull
    public static zzyq zza(@NonNull Exception exc, @NonNull String str, @NonNull String str2) {
        String message = exc.getMessage();
        Log.e(str, "Failed to parse " + str + " for string [" + str2 + "] with exception: " + message);
        return new zzyq("Failed to parse " + str + " for string [" + str2 + "]", exc);
    }

    @NonNull
    public static List zzb(@Nullable JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(jSONArray.getString(i11));
            }
        }
        return arrayList;
    }

    public static void zzc(JSONObject jSONObject) throws JSONException {
        jSONObject.put("clientType", (Object) "CLIENT_TYPE_ANDROID");
    }

    public static void zzd(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, (Object) str2);
        jSONObject.put("recaptchaVersion", (Object) "RECAPTCHA_ENTERPRISE");
        jSONObject.put("clientType", (Object) "CLIENT_TYPE_ANDROID");
    }
}
