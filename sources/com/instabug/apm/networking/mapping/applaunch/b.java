package com.instabug.apm.networking.mapping.applaunch;

import android.annotation.SuppressLint;
import com.facebook.appevents.UserDataStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
public class b implements a {
    public JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) a((com.instabug.apm.cache.model.b) it.next()));
        }
        return jSONArray;
    }

    public JSONObject a(com.instabug.apm.cache.model.b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", (Object) bVar.f());
        jSONObject.put(UserDataStore.STATE, bVar.e());
        jSONObject.put("dmus", bVar.a());
        jSONObject.put("sn", (Object) bVar.c());
        Map d11 = bVar.d();
        if (d11 != null && d11.size() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : d11.entrySet()) {
                String str = (String) entry.getValue();
                String str2 = (String) entry.getKey();
                try {
                    jSONObject2.put(str2, Long.parseLong(str));
                } catch (NumberFormatException unused) {
                    jSONObject2.put(str2, (Object) str);
                }
            }
            jSONObject.put("stgs", (Object) jSONObject2);
        }
        return jSONObject;
    }
}
