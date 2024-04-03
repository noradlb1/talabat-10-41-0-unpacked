package com.instabug.apm.networking.mapping.fragment_span;

import com.facebook.appevents.UserDataStore;
import com.instabug.apm.cache.model.d;
import com.instabug.apm.cache.model.e;
import com.instabug.apm.cache.model.g;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    private final JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) a((e) it.next()));
        }
        return jSONArray;
    }

    private final JSONObject a(d dVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("n", (Object) dVar.c());
        jSONObject.put("stgs", (Object) a(dVar.a()));
        return jSONObject;
    }

    private final JSONObject a(e eVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("n", (Object) eVar.b());
        jSONObject.put(UserDataStore.STATE, eVar.c());
        jSONObject.put("dmus", eVar.a());
        return jSONObject;
    }

    private final JSONArray b(List list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put((Object) a((d) it.next()));
            }
        }
        return jSONArray;
    }

    @Nullable
    public JSONObject a(@Nullable List list, @Nullable g gVar) {
        JSONObject jSONObject = null;
        if (gVar == null) {
            return null;
        }
        if (gVar.f() != 0) {
            jSONObject = new JSONObject();
            int size = list == null ? 0 : list.size();
            int e11 = gVar.e();
            int b11 = gVar.b(size);
            if (e11 > 0) {
                jSONObject.put("dcrl", e11);
            }
            if (b11 > 0) {
                jSONObject.put("dcsl", b11);
            }
            jSONObject.put("fl", (Object) b(list));
        }
        return jSONObject;
    }
}
