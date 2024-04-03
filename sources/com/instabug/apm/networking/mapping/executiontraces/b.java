package com.instabug.apm.networking.mapping.executiontraces;

import android.annotation.SuppressLint;
import com.facebook.appevents.UserDataStore;
import com.instabug.apm.cache.model.c;
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
            jSONArray.put((Object) a((c) it.next()));
        }
        return jSONArray;
    }

    public JSONObject a(c cVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("n", (Object) cVar.e());
        jSONObject.put(UserDataStore.STATE, cVar.f());
        jSONObject.put("dmus", cVar.c());
        if (cVar.b() != null && cVar.b().size() > 0) {
            jSONObject.put("att", (Object) new JSONObject((Map<?, ?>) cVar.b()));
        }
        jSONObject.put("bg", cVar.g());
        return jSONObject;
    }
}
