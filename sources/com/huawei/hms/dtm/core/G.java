package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class G implements D {

    /* renamed from: a  reason: collision with root package name */
    private final W f48301a;

    public G(W w11) {
        this.f48301a = w11;
    }

    private C0419pb a(JSONArray jSONArray, Set<String> set) throws JSONException {
        int i11 = 3;
        if (jSONArray.length() >= 3) {
            String string = jSONArray.getString(1);
            if (!TextUtils.isEmpty(string)) {
                Object obj = jSONArray.get(2);
                if (obj instanceof JSONArray) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = (JSONArray) obj;
                    for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                        arrayList.add(jSONArray2.getString(i12));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    while (i11 < jSONArray.length()) {
                        Object obj2 = jSONArray.get(i11);
                        if (obj2 instanceof JSONObject) {
                            arrayList2.add(b((JSONObject) obj2, set));
                            i11++;
                        } else {
                            throw new JSONException("the segment of function should be a JSONObject");
                        }
                    }
                    return new C0419pb(string, arrayList, arrayList2);
                }
                throw new JSONException("function params not json array");
            }
            throw new JSONException("function name empty");
        }
        throw new JSONException("function should not less than 3 parts");
    }

    private C0435sc<?> a(Object obj) {
        return obj instanceof String ? new Cc((String) obj) : obj instanceof Integer ? new C0450vc((Integer) obj) : obj instanceof Double ? new C0440tc((Double) obj) : obj instanceof Boolean ? C0430rc.a(((Boolean) obj).booleanValue()) : obj instanceof Long ? new C0460xc((Long) obj) : obj == JSONObject.NULL ? C0470zc.f48641a : new Ac(obj);
    }

    private Bc b(JSONObject jSONObject, Set<String> set) throws JSONException {
        Object a11;
        if (jSONObject == null || jSONObject.length() != 1) {
            throw new JSONException("wrong json type for segments");
        }
        String next = jSONObject.keys().next();
        if (!TextUtils.isEmpty(next)) {
            set.add(next);
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    Object obj2 = jSONArray.get(i11);
                    if (obj2 instanceof JSONObject) {
                        a11 = b((JSONObject) obj2, set);
                    } else if (!(obj2 instanceof JSONArray)) {
                        a11 = a(obj2);
                    } else {
                        throw new JSONException("wrong json type for segments");
                    }
                    arrayList.add(a11);
                }
                return new Bc(next, arrayList);
            }
            throw new JSONException("params for segments must be a json array");
        }
        throw new JSONException("name of segments can't be null");
    }

    public void a(JSONObject jSONObject, Set<String> set) throws JSONException {
        this.f48301a.a();
        this.f48301a.c();
        if (jSONObject.has("functions")) {
            Object obj = jSONObject.get("functions");
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                HashSet hashSet = new HashSet();
                int i11 = 0;
                while (i11 < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i11);
                    if (obj2 instanceof JSONArray) {
                        this.f48301a.a(a((JSONArray) obj2, (Set<String>) hashSet));
                        i11++;
                    } else {
                        throw new JSONException("function not json array");
                    }
                }
                this.f48301a.a((Set<String>) hashSet);
                return;
            }
            throw new JSONException("functions no json array");
        }
    }
}
