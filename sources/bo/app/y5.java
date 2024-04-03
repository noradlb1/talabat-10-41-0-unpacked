package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class y5 implements v2 {
    public boolean a(w2 w2Var) {
        return w2Var instanceof z5;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "test");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
