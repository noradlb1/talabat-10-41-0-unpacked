package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.Cdo;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public abstract class f implements h {
    protected cb ikl;
    protected Context klm;
    protected String lmn = "BaseCampHandler";

    private static JSONArray klm(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() < 20) {
                return jSONArray;
            }
            List<JSONObject> klm2 = dm.klm(jSONArray);
            Collections.sort(klm2, new Cdo.lmn());
            if (klm2.size() >= 20) {
                klm2.remove(0);
            }
            return dm.lmn(klm2);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    private JSONArray lmn(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        String klm2 = dv.klm(this.klm, "global_v2", str, "");
        if (TextUtils.isEmpty(klm2)) {
            return new JSONArray().put((Object) jSONObject);
        }
        JSONArray klm3 = klm(klm2);
        klm3.put((Object) jSONObject);
        return klm3;
    }

    public static boolean lmn(String str) {
        return TextUtils.isEmpty(str) || str.length() > 20480;
    }

    public final at lmn(as asVar) {
        return new at(this.ikl.klm("_push_msgid"), this.ikl.klm("_push_cmd_type"), String.valueOf(this.ikl.ikl("_push_notifyid")), asVar);
    }

    public final void lmn(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            JSONArray lmn2 = lmn(jSONObject, "camp_info");
            JSONArray lmn3 = lmn(jSONObject2, "camp_evt");
            Context context = this.klm;
            Object[] objArr = new Object[4];
            objArr[0] = "camp_info";
            objArr[1] = !(lmn2 instanceof JSONArray) ? lmn2.toString() : JSONArrayInstrumentation.toString(lmn2);
            objArr[2] = "camp_evt";
            objArr[3] = !(lmn3 instanceof JSONArray) ? lmn3.toString() : JSONArrayInstrumentation.toString(lmn3);
            dv.lmn(context, "global_v2", objArr);
        }
    }
}
