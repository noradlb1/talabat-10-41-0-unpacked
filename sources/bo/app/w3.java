package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class w3 implements v2 {
    public boolean a(w2 w2Var) {
        return w2Var instanceof x3;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "open");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
