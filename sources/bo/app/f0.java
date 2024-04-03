package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import org.json.JSONException;
import org.json.JSONObject;

public final class f0 extends d6 {

    /* renamed from: e  reason: collision with root package name */
    private static final String f38515e = BrazeLogger.getBrazeLogTag((Class<?>) f0.class);

    /* renamed from: d  reason: collision with root package name */
    private String f38516d;

    public f0(JSONObject jSONObject) {
        super(jSONObject);
        this.f38516d = jSONObject.getJSONObject("data").getString(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME);
    }

    public boolean a(w2 w2Var) {
        if (!(w2Var instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) w2Var;
        if (StringUtils.isNullOrBlank(e0Var.f()) || !e0Var.f().equals(this.f38516d)) {
            return false;
        }
        return super.a(w2Var);
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject e11 = super.forJsonPut();
        try {
            e11.put("type", (Object) "custom_event_property");
            JSONObject jSONObject = e11.getJSONObject("data");
            jSONObject.put(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME, (Object) this.f38516d);
            e11.put("data", (Object) jSONObject);
        } catch (JSONException e12) {
            BrazeLogger.e(f38515e, "Caught exception creating CustomEventWithPropertiesTriggerCondition Json.", e12);
        }
        return e11;
    }
}
