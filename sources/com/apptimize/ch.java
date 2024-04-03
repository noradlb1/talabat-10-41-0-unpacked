package com.apptimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ch implements bw, cs {

    /* renamed from: a  reason: collision with root package name */
    private final ci f41644a;

    /* renamed from: b  reason: collision with root package name */
    private final bv f41645b;

    /* renamed from: c  reason: collision with root package name */
    private final cf f41646c;

    /* renamed from: d  reason: collision with root package name */
    private final List<cm> f41647d;

    /* renamed from: e  reason: collision with root package name */
    private final List<cl> f41648e;

    /* renamed from: f  reason: collision with root package name */
    private final cj f41649f;

    /* renamed from: g  reason: collision with root package name */
    private final List<cs> f41650g;

    private ch(ci ciVar, bv bvVar, cf cfVar, List<cm> list, List<cl> list2, cj cjVar) {
        this.f41644a = ciVar;
        this.f41645b = bvVar;
        this.f41646c = cfVar;
        this.f41647d = list;
        this.f41648e = list2;
        this.f41649f = cjVar;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f());
        arrayList.addAll(g());
        this.f41650g = Collections.unmodifiableList(arrayList);
    }

    public static ch a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        ci a11 = ci.a();
        JSONArray optJSONArray = jSONObject.optJSONArray("ranges");
        if (optJSONArray != null) {
            a11 = ci.a(optJSONArray);
        }
        ci ciVar = a11;
        bv a12 = bv.a(jSONObject, auVar);
        cf a13 = cf.a(jSONObject, auVar);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("variants");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 != optJSONArray2.length(); i11++) {
                arrayList.add(cm.a(optJSONArray2.getJSONObject(i11), auVar));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("seedGroups");
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 != optJSONArray3.length(); i12++) {
                arrayList2.add(cl.a(optJSONArray3.getJSONObject(i12), auVar));
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkParameters");
        return new ch(ciVar, a12, a13, arrayList, arrayList2, optJSONObject != null ? cj.a(optJSONObject) : null);
    }

    public List<az> b() {
        return this.f41645b.a();
    }

    public List<az> c() {
        return this.f41646c.a();
    }

    public ci d() {
        return this.f41644a;
    }

    public List<cs> e() {
        return this.f41650g;
    }

    public List<cm> f() {
        return this.f41647d;
    }

    public List<cl> g() {
        return this.f41648e;
    }

    public cj h() {
        return this.f41649f;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!this.f41644a.c().isEmpty()) {
            jSONObject.put("ranges", (Object) this.f41644a.b());
        }
        this.f41645b.a(jSONObject);
        this.f41646c.a(jSONObject);
        if (!this.f41647d.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (cm d11 : this.f41647d) {
                jSONArray.put((Object) d11.d());
            }
            jSONObject.put("variants", (Object) jSONArray);
        }
        if (!this.f41648e.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            for (cl a11 : this.f41648e) {
                jSONArray2.put((Object) a11.a());
            }
            jSONObject.put("seedGroups", (Object) jSONArray2);
        }
        cj cjVar = this.f41649f;
        if (cjVar != null) {
            jSONObject.put("sdkParameters", (Object) cjVar.c());
        }
        return jSONObject;
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}
