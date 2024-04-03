package com.huawei.hms.analytics;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dm {
    private static final List<String> klm;
    private static final String[] lmn;

    static {
        String[] strArr = {"_campaign_info"};
        lmn = strArr;
        klm = Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public static List<JSONObject> klm(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                arrayList.add(jSONArray.getJSONObject(i11));
            } catch (JSONException unused) {
                HiLog.w("ConvertMethod", "json array item is not jsonObject");
            }
        }
        return arrayList;
    }

    public static Map<String, String> klm(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return hashMap;
    }

    public static Bundle lmn(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return (Bundle) bundle.clone();
    }

    public static String lmn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return new JSONObject(str).getString(str2);
        } catch (JSONException unused) {
            HiLog.w("ConvertMethod", "JSONException: Failed to obtain the key from jsonStr.");
            return "";
        }
    }

    public static Map<String, String> lmn(JSONObject jSONObject) {
        String optString;
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || jSONObject.length() == 0)) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("_restriction_shared".equals(next)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(av.lmn().lmn.def);
                    optString = sb2.toString();
                } else if (!dl.lmn(next, klm)) {
                    optString = jSONObject.optString(next);
                }
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    public static JSONArray lmn(List<JSONObject> list) {
        JSONArray jSONArray = new JSONArray();
        for (JSONObject put : list) {
            jSONArray.put((Object) put);
        }
        return jSONArray;
    }

    public static JSONArray lmn(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new JSONArray();
        }
        if (1000 >= jSONArray.length()) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < 1000; i11++) {
            try {
                jSONArray2.put(jSONArray.get(i11));
            } catch (JSONException unused) {
                HiLog.w("ConvertMethod", "truncate JSONArray error");
            }
        }
        return jSONArray2;
    }

    public static JSONObject lmn(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), next.getValue());
            } catch (JSONException unused) {
                HiLog.w("ConvertMethod", "map to json exception");
            }
        }
        return jSONObject;
    }
}
