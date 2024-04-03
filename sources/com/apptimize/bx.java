package com.apptimize;

import com.apptimize.bt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bx implements bu, bw, cs {

    /* renamed from: a  reason: collision with root package name */
    private final bv f41516a;

    /* renamed from: b  reason: collision with root package name */
    private final cf f41517b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41518c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f41519d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f41520e;

    /* renamed from: f  reason: collision with root package name */
    private final String f41521f;

    /* renamed from: g  reason: collision with root package name */
    private final Long f41522g;

    /* renamed from: h  reason: collision with root package name */
    private final String f41523h;

    /* renamed from: i  reason: collision with root package name */
    private final List<? extends bt> f41524i;

    /* renamed from: j  reason: collision with root package name */
    private final List<cs> f41525j;

    public bx(bv bvVar, cf cfVar, String str, Long l11, Long l12, String str2, Long l13, String str3, List<? extends bt> list) {
        this.f41516a = bvVar;
        this.f41517b = cfVar;
        this.f41519d = l11;
        this.f41523h = str;
        this.f41520e = l12;
        this.f41518c = str2;
        this.f41522g = l13;
        this.f41521f = str3;
        this.f41524i = list;
        for (bt btVar : list) {
            if (btVar instanceof bt.k) {
                for (df a11 : ((bt.k) btVar).g().f41755a) {
                    a11.a(l13);
                }
            }
        }
        this.f41525j = Collections.unmodifiableList(new ArrayList(f()));
    }

    public static bx a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        bv a11 = bv.a(jSONObject, auVar);
        cf a12 = cf.a(jSONObject, auVar);
        Long valueOf = Long.valueOf(jSONObject.optLong("instantId", -1));
        Long l11 = valueOf.longValue() == -1 ? null : valueOf;
        String optString = jSONObject.optString("hotfixName");
        if (optString == null || "".equals(optString)) {
            optString = "Unknown hotfix name";
        }
        String str = optString;
        Long valueOf2 = Long.valueOf(jSONObject.optLong(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, -1));
        Long l12 = valueOf2.longValue() == -1 ? null : valueOf2;
        String optString2 = jSONObject.optString("variantName");
        String str2 = (optString2 == null || "".equals(optString2)) ? null : optString2;
        Long valueOf3 = Long.valueOf(jSONObject.optLong(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, -1));
        Long l13 = valueOf3.longValue() == -1 ? null : valueOf3;
        String optString3 = jSONObject.optString("hotfixType");
        String str3 = (optString3 == null || "".equals(optString3)) ? null : optString3;
        ArrayList arrayList = new ArrayList();
        a(arrayList, jSONObject, "alterations", auVar);
        a(arrayList, jSONObject, "alterations2", auVar);
        return new bx(a11, a12, str3, l11, l12, str, l13, str2, arrayList);
    }

    public List<az> b() {
        return this.f41516a.a();
    }

    public List<az> c() {
        return this.f41517b.a();
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.f41516a.a(jSONObject);
        this.f41517b.a(jSONObject);
        Long l11 = this.f41519d;
        if (l11 != null) {
            jSONObject.put("instantId", l11.longValue());
        }
        if (!this.f41518c.equals("Unknown hotfix name")) {
            jSONObject.put("hotfixName", (Object) this.f41518c);
        }
        Long l12 = this.f41520e;
        if (l12 != null) {
            jSONObject.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, l12.longValue());
        }
        String str = this.f41521f;
        if (str != null) {
            jSONObject.put("variantName", (Object) str);
        }
        Long l13 = this.f41522g;
        if (l13 != null) {
            jSONObject.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, l13.longValue());
        }
        String str2 = this.f41523h;
        if (str2 != null) {
            jSONObject.put("hotfixType", (Object) str2);
        }
        if (!this.f41524i.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (bt d11 : this.f41524i) {
                jSONArray.put((Object) d11.d());
            }
            jSONObject.put("alterations", (Object) jSONArray);
        }
        return jSONObject;
    }

    public List<cs> e() {
        return this.f41525j;
    }

    public List<? extends bt> f() {
        return this.f41524i;
    }

    public String g() {
        String str = this.f41523h;
        if (str != null && !"".equals(str)) {
            return this.f41523h;
        }
        if (this.f41522g == null) {
            return "InstantUpdate";
        }
        return "Winner";
    }

    public Boolean h() {
        return Boolean.valueOf("InstantUpdate".equals(g()));
    }

    public Boolean i() {
        return Boolean.valueOf("Winner".equals(g()));
    }

    public String j() {
        return this.f41518c;
    }

    public Long k() {
        return this.f41520e;
    }

    public Long l() {
        return this.f41519d;
    }

    public Boolean m() {
        return Boolean.valueOf(this.f41522g != null);
    }

    public String n() {
        return this.f41521f;
    }

    public JSONArray b(bb bbVar) throws JSONException {
        return az.a((Collection<az>) az.b(b(), bbVar), bbVar);
    }

    private static void a(List<bt> list, JSONObject jSONObject, String str, au auVar) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            for (int i11 = 0; i11 != optJSONArray.length(); i11++) {
                list.add(bt.a(optJSONArray.getJSONObject(i11), auVar));
            }
        }
    }

    public Long a() {
        return this.f41522g;
    }

    public JSONArray a(bb bbVar) throws JSONException {
        return az.a((Collection<az>) az.a(b(), bbVar), bbVar);
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}
