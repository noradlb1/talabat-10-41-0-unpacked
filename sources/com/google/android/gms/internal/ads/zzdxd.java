package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzdxd {
    public static String zza(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str2)) == null)) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (optJSONObject != null) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("including");
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("excluding");
                    if (zzb(optJSONArray2, str) && !zzb(optJSONArray3, str)) {
                        return optJSONObject.optString("effective_ad_unit_id", "");
                    }
                }
            }
        }
        return "";
    }

    private static boolean zzb(JSONArray jSONArray, String str) {
        Pattern pattern;
        if (!(jSONArray == null || str == null)) {
            int i11 = 0;
            while (i11 < jSONArray.length()) {
                String optString = jSONArray.optString(i11);
                try {
                    if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhq)).booleanValue()) {
                        pattern = Pattern.compile(optString, 2);
                    } else {
                        pattern = Pattern.compile(optString);
                    }
                    if (pattern.matcher(str).lookingAt()) {
                        return true;
                    }
                    i11++;
                } catch (PatternSyntaxException e11) {
                    zzt.zzo().zzs(e11, "RtbAdapterMap.hasAtleastOneRegexMatch");
                }
            }
        }
        return false;
    }
}
