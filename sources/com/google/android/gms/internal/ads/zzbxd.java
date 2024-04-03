package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbxd {
    public static final List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            arrayList.add(optJSONArray.getString(i11));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
