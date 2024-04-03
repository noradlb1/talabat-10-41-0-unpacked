package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class g4 extends d6 {

    /* renamed from: e  reason: collision with root package name */
    private static final String f38540e = BrazeLogger.getBrazeLogTag((Class<?>) g4.class);

    /* renamed from: d  reason: collision with root package name */
    private String f38541d;

    public g4(JSONObject jSONObject) {
        super(jSONObject);
        this.f38541d = jSONObject.getJSONObject("data").getString(TalabatCommonUrlConstantsKt.PRODUCT_ID);
    }

    public boolean a(w2 w2Var) {
        if (!(w2Var instanceof f4) || StringUtils.isNullOrBlank(this.f38541d)) {
            return false;
        }
        f4 f4Var = (f4) w2Var;
        if (!StringUtils.isNullOrBlank(f4Var.f()) && f4Var.f().equals(this.f38541d)) {
            return super.a(w2Var);
        }
        return false;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject e11 = super.forJsonPut();
        try {
            e11.put("type", (Object) "purchase_property");
            JSONObject jSONObject = e11.getJSONObject("data");
            jSONObject.put(TalabatCommonUrlConstantsKt.PRODUCT_ID, (Object) this.f38541d);
            e11.put("data", (Object) jSONObject);
        } catch (JSONException e12) {
            BrazeLogger.e(f38540e, "Caught exception creating Json.", e12);
        }
        return e11;
    }
}
