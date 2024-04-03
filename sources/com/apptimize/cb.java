package com.apptimize;

import com.apptimize.cj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cb extends by implements bw, cs {

    /* renamed from: a  reason: collision with root package name */
    private final int f41605a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41606b;

    /* renamed from: c  reason: collision with root package name */
    private final int f41607c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f41608d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f41609e;

    /* renamed from: f  reason: collision with root package name */
    private final bv f41610f;

    /* renamed from: g  reason: collision with root package name */
    private final cf f41611g;

    /* renamed from: h  reason: collision with root package name */
    private final List<cl> f41612h;

    /* renamed from: i  reason: collision with root package name */
    private final List<bx> f41613i;

    /* renamed from: j  reason: collision with root package name */
    private final List<cn> f41614j;

    /* renamed from: k  reason: collision with root package name */
    private final List<ce> f41615k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f41616l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Map<Long, cm> f41617m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public List<cm> f41618n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public List<bu> f41619o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public List<dc> f41620p;

    /* renamed from: q  reason: collision with root package name */
    private cj f41621q;

    public cb() {
        this.f41616l = false;
        this.f41617m = new HashMap();
        this.f41618n = new ArrayList();
        this.f41619o = new ArrayList();
        this.f41620p = new ArrayList();
        this.f41605a = -1;
        this.f41606b = null;
        this.f41607c = -1;
        this.f41608d = null;
        this.f41609e = null;
        this.f41610f = null;
        this.f41611g = null;
        this.f41612h = null;
        this.f41613i = null;
        this.f41614j = null;
        this.f41615k = null;
    }

    private synchronized void n() {
        if (!this.f41616l) {
            this.f41616l = true;
            final cj.a a11 = cj.a.a();
            a((co) new cy(new cr() {
                public boolean a(cm cmVar) {
                    cb.this.f41617m.put(Long.valueOf(cmVar.j()), cmVar);
                    cb.this.f41618n.add(cmVar);
                    cb.this.f41619o.add(cmVar);
                    return true;
                }

                public boolean a(bx bxVar) {
                    cb.this.f41619o.add(bxVar);
                    return true;
                }

                public boolean a(bt btVar) {
                    btVar.a((List<dc>) cb.this.f41620p);
                    return true;
                }

                public boolean a(cn cnVar) {
                    cb.this.f41620p.add(cnVar.d());
                    return true;
                }

                public boolean a(ch chVar) {
                    a11.a(chVar.h());
                    return true;
                }
            }));
            this.f41621q = a11.b();
        }
    }

    public List<cs> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f41612h);
        arrayList.addAll(this.f41613i);
        arrayList.addAll(this.f41614j);
        arrayList.addAll(this.f41615k);
        return Collections.unmodifiableList(arrayList);
    }

    public int f() {
        return this.f41607c;
    }

    public List<String> g() {
        return this.f41609e;
    }

    public List<ce> h() {
        return this.f41615k;
    }

    public List<bx> i() {
        return this.f41613i;
    }

    public List<cn> j() {
        return this.f41614j;
    }

    public List<cm> k() {
        n();
        return this.f41618n;
    }

    public List<bu> l() {
        n();
        return this.f41619o;
    }

    public cj m() {
        n();
        return this.f41621q;
    }

    public static cb b(JSONObject jSONObject, au auVar) throws JSONException, ca {
        int i11 = jSONObject.getInt("schemaVersion");
        if (i11 == 4) {
            String string = jSONObject.getString("appKey");
            if (string == null || "".equals(string)) {
                throw new ca("App key invalid");
            }
            int i12 = jSONObject.getInt("sequenceNumber");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("disabledAndroidLibraryVersions");
            if (optJSONArray != null) {
                for (int i13 = 0; i13 != optJSONArray.length(); i13++) {
                    arrayList.add(optJSONArray.getString(i13));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("checkinUrls");
            for (int i14 = 0; i14 != jSONArray.length(); i14++) {
                String string2 = jSONArray.getString(i14);
                if (string2 == null || "".equals(string2)) {
                    throw new ca("Checkin urls invalid");
                }
                arrayList2.add(string2);
            }
            if (arrayList2.size() != 0) {
                bv a11 = bv.a(jSONObject, auVar);
                cf a12 = cf.a(jSONObject, auVar);
                ArrayList arrayList3 = new ArrayList();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("seedGroups");
                if (optJSONArray2 != null) {
                    for (int i15 = 0; i15 != optJSONArray2.length(); i15++) {
                        arrayList3.add(cl.a(optJSONArray2.getJSONObject(i15), auVar));
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("hotfixes");
                if (optJSONArray3 != null) {
                    for (int i16 = 0; i16 != optJSONArray3.length(); i16++) {
                        arrayList4.add(bx.a(optJSONArray3.getJSONObject(i16), auVar));
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                JSONArray optJSONArray4 = jSONObject.optJSONArray("wysiwygMetrics");
                if (optJSONArray4 != null) {
                    for (int i17 = 0; i17 != optJSONArray4.length(); i17++) {
                        arrayList5.add(cn.a(optJSONArray4.getJSONObject(i17), auVar));
                    }
                }
                ArrayList arrayList6 = new ArrayList();
                JSONArray optJSONArray5 = jSONObject.optJSONArray("namedFilters");
                if (optJSONArray5 != null) {
                    for (int i18 = 0; i18 < optJSONArray5.length(); i18++) {
                        arrayList6.add(ce.a(optJSONArray5.getJSONObject(i18), auVar));
                    }
                }
                return new cb(i11, string, i12, arrayList, arrayList2, a11, a12, arrayList3, arrayList4, arrayList5, arrayList6);
            }
            throw new ca("No checkin urls");
        }
        throw new ca("Unexpected schema version");
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("schemaVersion", this.f41605a);
        jSONObject.put("appKey", (Object) this.f41606b);
        jSONObject.put("sequenceNumber", this.f41607c);
        if (!this.f41608d.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String put : this.f41608d) {
                jSONArray.put((Object) put);
            }
            jSONObject.put("disabledAndroidLibraryVersions", (Object) jSONArray);
        }
        JSONArray jSONArray2 = new JSONArray();
        for (String put2 : this.f41609e) {
            jSONArray2.put((Object) put2);
        }
        jSONObject.put("checkinUrls", (Object) jSONArray2);
        this.f41610f.a(jSONObject);
        this.f41611g.a(jSONObject);
        if (!this.f41612h.isEmpty()) {
            JSONArray jSONArray3 = new JSONArray();
            for (cl a11 : this.f41612h) {
                jSONArray3.put((Object) a11.a());
            }
            jSONObject.put("seedGroups", (Object) jSONArray3);
        }
        if (!this.f41613i.isEmpty()) {
            JSONArray jSONArray4 = new JSONArray();
            for (bx d11 : this.f41613i) {
                jSONArray4.put((Object) d11.d());
            }
            jSONObject.put("hotfixes", (Object) jSONArray4);
        }
        if (!this.f41614j.isEmpty()) {
            JSONArray jSONArray5 = new JSONArray();
            for (cn a12 : this.f41614j) {
                jSONArray5.put((Object) a12.a());
            }
            jSONObject.put("wysiwygMetrics", (Object) jSONArray5);
        }
        if (!this.f41615k.isEmpty()) {
            JSONArray jSONArray6 = new JSONArray();
            for (ce a13 : this.f41615k) {
                jSONArray6.put((Object) a13.a());
            }
            jSONObject.put("namedFilters", (Object) jSONArray6);
        }
        return jSONObject;
    }

    public List<az> c() {
        return this.f41611g.a();
    }

    public List<dc> d() {
        n();
        return this.f41620p;
    }

    private cb(int i11, String str, int i12, List<String> list, List<String> list2, bv bvVar, cf cfVar, List<cl> list3, List<bx> list4, List<cn> list5, List<ce> list6) {
        this.f41616l = false;
        this.f41617m = new HashMap();
        this.f41618n = new ArrayList();
        this.f41619o = new ArrayList();
        this.f41620p = new ArrayList();
        this.f41605a = i11;
        this.f41606b = str;
        this.f41607c = i12;
        this.f41608d = Collections.unmodifiableList(new ArrayList(list));
        this.f41609e = Collections.unmodifiableList(new ArrayList(list2));
        this.f41610f = bvVar;
        this.f41611g = cfVar;
        this.f41612h = Collections.unmodifiableList(new ArrayList(list3));
        this.f41613i = Collections.unmodifiableList(new ArrayList(list4));
        this.f41614j = Collections.unmodifiableList(new ArrayList(list5));
        this.f41615k = Collections.unmodifiableList(new ArrayList(list6));
    }

    public cm a(long j11) {
        n();
        return this.f41617m.get(Long.valueOf(j11));
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }

    public List<az> b() {
        return this.f41610f.a();
    }
}
