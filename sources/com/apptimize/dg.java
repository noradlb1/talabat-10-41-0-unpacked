package com.apptimize;

import com.apptimize.di;
import com.braze.models.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dg {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41771a = "dg";

    public static List<df> a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has(FeatureFlag.PROPERTIES)) {
            JSONArray jSONArray = jSONObject.getJSONArray(FeatureFlag.PROPERTIES);
            JSONObject jSONObject3 = null;
            if (jSONArray.length() <= 0) {
                jSONObject2 = null;
            } else {
                jSONObject2 = jSONArray.getJSONObject(0);
            }
            int c11 = di.a.c(jSONObject2);
            if (c11 != 0) {
                jSONObject3 = jSONObject2;
            }
            arrayList.add(new di.a(jSONObject3));
            while (c11 < jSONArray.length()) {
                di diVar = new di(jSONArray.getJSONObject(c11));
                arrayList.add(diVar);
                if (diVar.b().equals(hm.f42955d)) {
                    bo.e(f41771a, "Detected a top-level property of type image. The JSON representation of image properties has historicallycontained a number of top-level attributes that Android does not expect. Although theymay render properly, the JSON may not be saved to disk properly");
                }
                c11++;
            }
        }
        if (jSONObject.has("metrics")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("metrics");
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                arrayList.add(new dj(jSONArray2.getJSONObject(i11)));
            }
        }
        if (jSONObject.has(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE) && jSONObject.has("goalName")) {
            arrayList.add(new de(jSONObject));
        }
        return arrayList;
    }
}
