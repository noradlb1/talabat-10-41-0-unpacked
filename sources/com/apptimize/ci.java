package com.apptimize;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class ci {

    /* renamed from: a  reason: collision with root package name */
    private List<cg> f41651a;

    private ci(List<cg> list) {
        this.f41651a = list;
    }

    public static ci a() {
        return new ci(new ArrayList());
    }

    public JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (cg a11 : this.f41651a) {
            jSONArray.put((Object) a11.a());
        }
        return jSONArray;
    }

    public List<cg> c() {
        return this.f41651a;
    }

    public static ci a(JSONArray jSONArray) throws JSONException, ca {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 != jSONArray.length(); i11++) {
            arrayList.add(cg.a(jSONArray.getJSONArray(i11)));
        }
        return new ci(arrayList);
    }
}
