package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzdtg {
    private final Executor zza;
    private final zzdtb zzb;

    public zzdtg(Executor executor, zzdtb zzdtb) {
        this.zza = executor;
        this.zzb = zzdtb;
    }

    public final zzfxa<List<zzdtf>> zza(JSONObject jSONObject, String str) {
        zzfxa<O> zzfxa;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzfwq.zzi(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
            if (optJSONObject == null) {
                zzfxa = zzfwq.zzi(null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzfxa = zzfwq.zzi(null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if (TypedValues.Custom.S_STRING.equals(optString2)) {
                        zzfxa = zzfwq.zzi(new zzdtf(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzfxa = zzfwq.zzm(this.zzb.zze(optJSONObject, "image_value"), new zzdtd(optString), this.zza);
                    } else {
                        zzfxa = zzfwq.zzi(null);
                    }
                }
            }
            arrayList.add(zzfxa);
        }
        return zzfwq.zzm(zzfwq.zze(arrayList), zzdte.zza, this.zza);
    }
}
