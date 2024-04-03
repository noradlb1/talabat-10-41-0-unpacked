package bo.app;

import com.braze.support.StringUtils;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class e4 implements v2 {

    /* renamed from: b  reason: collision with root package name */
    String f38482b;

    public e4(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && !optJSONObject.isNull(TalabatCommonUrlConstantsKt.PRODUCT_ID)) {
            this.f38482b = optJSONObject.optString(TalabatCommonUrlConstantsKt.PRODUCT_ID, (String) null);
        }
    }

    public boolean a(w2 w2Var) {
        if (!(w2Var instanceof f4)) {
            return false;
        }
        if (StringUtils.isNullOrBlank(this.f38482b)) {
            return true;
        }
        f4 f4Var = (f4) w2Var;
        if (StringUtils.isNullOrBlank(f4Var.f()) || !f4Var.f().equals(this.f38482b)) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "purchase");
            if (this.f38482b != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(TalabatCommonUrlConstantsKt.PRODUCT_ID, this.f38482b);
                jSONObject.putOpt("data", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
