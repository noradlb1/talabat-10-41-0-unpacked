package bo.app;

import com.braze.support.StringUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d3 implements v2 {

    /* renamed from: b  reason: collision with root package name */
    private String f38447b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f38448c = new HashSet();

    public d3(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.f38447b = jSONObject2.getString("id");
        JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
        if (optJSONArray != null) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                this.f38448c.add(optJSONArray.getString(i11));
            }
        }
    }

    public boolean a(w2 w2Var) {
        if (w2Var instanceof e3) {
            e3 e3Var = (e3) w2Var;
            if (!StringUtils.isNullOrBlank(e3Var.g()) && e3Var.g().equals(this.f38447b)) {
                if (this.f38448c.size() <= 0) {
                    return StringUtils.isNullOrBlank(e3Var.f());
                }
                if (StringUtils.isNullOrBlank(e3Var.f()) || !this.f38448c.contains(e3Var.f())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "iam_click");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", (Object) this.f38447b);
            if (this.f38448c.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.f38448c) {
                    jSONArray.put((Object) put);
                }
                jSONObject2.put("buttons", (Object) jSONArray);
            }
            jSONObject.put("data", (Object) jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
