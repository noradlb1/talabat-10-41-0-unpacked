package com.google.firebase.auth.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.p002firebaseauthapi.zzab;
import com.google.android.gms.internal.p002firebaseauthapi.zzj;
import com.google.android.gms.internal.p002firebaseauthapi.zzwh;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbb {
    private static final Logger zza = new Logger("JSONParser", new String[0]);

    @VisibleForTesting
    public static List zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            Object obj = jSONArray.get(i11);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzd((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NonNull
    public static Map zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List zzd = zzab.zzb(zzj.zzb('.')).zzd(str);
        if (zzd.size() < 2) {
            zza.e("Invalid idToken ".concat(String.valueOf(str)), new Object[0]);
            return new HashMap();
        }
        try {
            Map zzc = zzc(new String(Base64Utils.decodeUrlSafeNoPadding((String) zzd.get(1)), "UTF-8"));
            if (zzc == null) {
                return new HashMap();
            }
            return zzc;
        } catch (UnsupportedEncodingException e11) {
            zza.e("Unable to decode token", e11, new Object[0]);
            return new HashMap();
        }
    }

    @Nullable
    public static Map zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzd(jSONObject);
            }
            return null;
        } catch (Exception e11) {
            throw new zzwh(e11);
        }
    }

    @VisibleForTesting
    public static Map zzd(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzd((JSONObject) obj);
            }
            arrayMap.put(next, obj);
        }
        return arrayMap;
    }
}
