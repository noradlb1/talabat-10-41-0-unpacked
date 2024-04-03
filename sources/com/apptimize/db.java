package com.apptimize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class db implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f41754a;

    public db(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next, fh.a(jSONObject.get(next)));
            }
        }
        dd.a(hashMap);
        this.f41754a = Collections.unmodifiableMap(hashMap);
    }

    public JSONObject a() {
        return new JSONObject((Map<?, ?>) this.f41754a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof db)) {
            return false;
        }
        return this.f41754a.equals(((db) obj).f41754a);
    }

    public int a(db dbVar, bf bfVar) {
        Object obj;
        int i11 = 0;
        for (String next : this.f41754a.keySet()) {
            if (dbVar.f41754a.containsKey(next)) {
                obj = dbVar.f41754a.get(next);
            } else {
                obj = bfVar.a(next);
            }
            if (!ey.a(this.f41754a.get(next), obj)) {
                return -1;
            }
            i11++;
        }
        return i11;
    }

    public static List<db> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(new db(jSONArray.getJSONObject(i11)));
        }
        return arrayList;
    }

    public db(Map<String, Object> map) {
        this.f41754a = Collections.unmodifiableMap(new HashMap(map));
    }

    public static JSONArray a(List<db> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (db a11 : list) {
            jSONArray.put((Object) a11.a());
        }
        return jSONArray;
    }
}
