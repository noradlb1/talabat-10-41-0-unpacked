package com.apptimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dc {

    /* renamed from: a  reason: collision with root package name */
    public final List<df> f41755a;

    /* renamed from: b  reason: collision with root package name */
    public final List<db> f41756b;

    public dc(List<df> list, List<db> list2) {
        this.f41755a = Collections.unmodifiableList(list);
        this.f41756b = Collections.unmodifiableList(list2);
    }

    public static dc a(JSONObject jSONObject) throws JSONException {
        return new dc(dg.a(jSONObject), db.a(jSONObject.getJSONArray("selector")));
    }

    public void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put("selector", (Object) db.a(this.f41756b));
        for (df b11 : this.f41755a) {
            b11.b(jSONObject);
        }
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject);
        return jSONObject;
    }

    public static List<dc> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(a(jSONArray.getJSONObject(i11)));
        }
        return arrayList;
    }

    public static List<df> a(List<dc> list) {
        ArrayList arrayList = new ArrayList();
        for (dc dcVar : list) {
            arrayList.addAll(dcVar.f41755a);
        }
        return arrayList;
    }
}
