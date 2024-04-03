package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzow;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzda {
    public static zzov zzbf(String str) throws JSONException {
        zzl zzi = zzgj.zzi(zzg(new JSONObject(str)));
        zzow zzmn = zzov.zzmn();
        for (int i11 = 0; i11 < zzi.zzqo.length; i11++) {
            zzmn.zzc(zzot.zzml().zzb(zzb.INSTANCE_NAME.toString(), zzi.zzqo[i11]).zzb(zzb.FUNCTION.toString(), zzgj.zzbp(zzt.zzgy())).zzb(zzt.zzgz(), zzi.zzqp[i11]).zzmm());
        }
        return zzmn.zzmp();
    }

    @VisibleForTesting
    private static Object zzg(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, zzg(jSONObject.get(next)));
            }
            return hashMap;
        }
    }
}
