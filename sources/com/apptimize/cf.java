package com.apptimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cf {

    /* renamed from: a  reason: collision with root package name */
    public static final cf f41640a = new cf(Collections.emptyList());

    /* renamed from: b  reason: collision with root package name */
    private final List<az> f41641b;

    public cf(List<az> list) {
        this.f41641b = Collections.unmodifiableList(new ArrayList(list));
    }

    public static cf a(JSONObject jSONObject, au auVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("overridingInclusiveFilters");
        if (optJSONArray != null) {
            for (int i11 = 0; i11 != optJSONArray.length(); i11++) {
                arrayList.add(az.a(optJSONArray.getJSONObject(i11), auVar));
            }
        }
        return new cf(arrayList);
    }

    public void a(JSONObject jSONObject) throws JSONException {
        if (!this.f41641b.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (az a11 : this.f41641b) {
                jSONArray.put((Object) a11.a());
            }
            jSONObject.put("overridingInclusiveFilters", (Object) jSONArray);
        }
    }

    public List<az> a() {
        return this.f41641b;
    }
}
