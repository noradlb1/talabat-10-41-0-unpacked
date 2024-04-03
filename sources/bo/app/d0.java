package bo.app;

import com.braze.support.StringUtils;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import org.json.JSONException;
import org.json.JSONObject;

public final class d0 implements v2 {

    /* renamed from: b  reason: collision with root package name */
    private String f38437b;

    public d0(JSONObject jSONObject) {
        this.f38437b = jSONObject.getJSONObject("data").getString(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME);
    }

    public boolean a(w2 w2Var) {
        if (!(w2Var instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) w2Var;
        if (StringUtils.isNullOrBlank(e0Var.f()) || !e0Var.f().equals(this.f38437b)) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "custom_event");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME, (Object) this.f38437b);
            jSONObject.put("data", (Object) jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
