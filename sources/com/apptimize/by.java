package com.apptimize;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class by {
    public static by a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        if (jSONObject.getInt("schemaVersion") == 4) {
            return cb.b(jSONObject, auVar);
        }
        throw new ca("Unexpected schema version");
    }

    public abstract JSONObject a() throws JSONException;

    public abstract List<dc> d();

    public abstract int f();

    public abstract List<String> g();
}
