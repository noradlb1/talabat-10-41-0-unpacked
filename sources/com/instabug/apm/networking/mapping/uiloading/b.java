package com.instabug.apm.networking.mapping.uiloading;

import androidx.annotation.Nullable;
import com.facebook.appevents.UserDataStore;
import com.instabug.apm.cache.model.i;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements a {
    @Nullable
    public JSONObject a(@Nullable i iVar) {
        if (iVar == null) {
            return null;
        }
        String f11 = iVar.f();
        Map d11 = iVar.d();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dmus", iVar.b());
        jSONObject.put(UserDataStore.STATE, iVar.e());
        if (f11 != null) {
            jSONObject.put("t", (Object) f11);
        }
        if (d11 != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : d11.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(entry.getValue());
                jSONObject2.put((String) entry.getKey(), (Object) jSONArray);
            }
            jSONObject.put("stgs", (Object) jSONObject2);
        }
        return jSONObject;
    }
}
