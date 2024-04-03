package com.huawei.hms.dtm.core;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

class E {
    public static List<String> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int i11 = 0;
        while (i11 < jSONArray.length()) {
            String string = jSONArray.getJSONObject(i11).getString("name");
            if (!arrayList.contains(string)) {
                arrayList.add(string);
                i11++;
            } else {
                throw new JSONException("json contains the same variable name#" + string);
            }
        }
        return arrayList;
    }
}
