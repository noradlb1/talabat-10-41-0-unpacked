package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d6 implements v2 {

    /* renamed from: c  reason: collision with root package name */
    private static final String f38456c = BrazeLogger.getBrazeLogTag((Class<?>) d6.class);

    /* renamed from: b  reason: collision with root package name */
    c f38457b;

    public d6(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("property_filters");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i11);
            ArrayList arrayList2 = new ArrayList();
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                arrayList2.add(new c4(jSONArray2.getJSONObject(i12)));
            }
            arrayList.add(new y3(arrayList2));
        }
        this.f38457b = new c(arrayList);
    }

    public boolean a(w2 w2Var) {
        return this.f38457b.a(w2Var);
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("property_filters", (Object) this.f38457b.forJsonPut());
            jSONObject.put("data", (Object) jSONObject2);
        } catch (JSONException e11) {
            BrazeLogger.e(f38456c, "Caught exception creating Json.", e11);
        }
        return jSONObject;
    }
}
