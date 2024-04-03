package bo.app;

import com.braze.support.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

public final class i4 implements v2 {

    /* renamed from: b  reason: collision with root package name */
    private String f38650b;

    public i4(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && !optJSONObject.isNull(FirebaseAnalytics.Param.CAMPAIGN_ID)) {
            this.f38650b = optJSONObject.optString(FirebaseAnalytics.Param.CAMPAIGN_ID, (String) null);
        }
    }

    public boolean a(w2 w2Var) {
        if (!(w2Var instanceof j4)) {
            return false;
        }
        if (StringUtils.isNullOrBlank(this.f38650b)) {
            return true;
        }
        j4 j4Var = (j4) w2Var;
        if (StringUtils.isNullOrBlank(j4Var.f()) || !j4Var.f().equals(this.f38650b)) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "push_click");
            if (this.f38650b != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(FirebaseAnalytics.Param.CAMPAIGN_ID, this.f38650b);
                jSONObject.putOpt("data", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
