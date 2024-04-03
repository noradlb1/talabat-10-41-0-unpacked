package com.instabug.apm.networking.mapping.experiment;

import com.instabug.apm.cache.model.g;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    @Nullable
    public JSONObject a(@Nullable List list, @Nullable g gVar) {
        if (list != null) {
            int a11 = gVar == null ? 0 : gVar.a(list.size());
            if ((!list.isEmpty()) || a11 > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("expl", (Object) new JSONArray((Collection<?>) list));
                if (a11 > 0) {
                    jSONObject.put("dxrl", a11);
                }
                return jSONObject;
            }
        }
        return null;
    }
}
